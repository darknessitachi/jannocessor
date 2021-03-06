/**
 * Copyright 2011 Nikolche Mihajlovski
 *
 * This file is part of JAnnocessor.
 *
 * JAnnocessor is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JAnnocessor is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with JAnnocessor.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.jannocessor.processor;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.JavaFileManager.Location;
import javax.tools.StandardLocation;

import org.jannocessor.JannocessorException;
import org.jannocessor.adapter.AdapterFactory;
import org.jannocessor.collection.Power;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.JavaElement;
import org.jannocessor.processor.api.CodeMerger;
import org.jannocessor.processor.api.CodeProcessor;
import org.jannocessor.processor.api.LifecycleEvent;
import org.jannocessor.processor.api.LifecycleListener;
import org.jannocessor.processor.api.ProcessingContext;
import org.jannocessor.processor.api.RenderData;
import org.jannocessor.processor.context.AbstractRenderRegister;
import org.jannocessor.processor.context.DefaultProcessingContext;
import org.jannocessor.processor.context.GeneratedCode;
import org.jannocessor.processor.context.GeneratedFile;
import org.jannocessor.processor.context.ProcessingConfiguration;
import org.jannocessor.processor.context.ProcessorsConfiguration;
import org.jannocessor.ui.RenderPreview;
import org.jannocessor.util.Jannocessor;

@SupportedSourceVersion(SourceVersion.RELEASE_6)
public class JannocessorProcessor extends JannocessorProcessorBase {

	private ProcessingContext context;

	@Override
	protected void processAnnotations(final Set<? extends TypeElement> annotations,
			final RoundEnvironment env) throws JannocessorException {

		context = createProcessingContext();
		
		notifyCodeGenStarted();
		
		renderRegister = new AbstractRenderRegister() {
			@Override
			public void refresh() throws JannocessorException {
				getRenderings().clear();
				processElements(annotations, env, createProcessingContext());
			}
		};

		renderRegister.refresh();

		/**************************************************************************/

		// show graphical user interface
		RenderPreview.showDialog(engine.getTemplatesPath(), renderRegister, engine, engine);

		// rendered the registered data again after UI processing
		renderRegistered();

		// generate files
		generateFiles();
		
		notifyCodeGenFinished();
	}

	private void notifyCodeGenFinished() {
		for (LifecycleListener listener : processorsConfig.getLifecycleListeners()) {
			listener.afterCodeGeneration(event());
		}
	}
	
	private void notifyCodeGenStarted() {
		for (LifecycleListener listener : processorsConfig.getLifecycleListeners()) {
			listener.beforeCodeGeneration(event());
		}
	}
	
	private LifecycleEvent event() {
		return new LifecycleEvent() {
			@Override
			public ProcessingContext getContext() {
				return context;
			}
		};
	}

	private void renderRegistered() throws JannocessorException {
		List<RenderData> renderings = renderRegister.getRenderings();

		// FIXME: some content will be double-processed (as both in "contents"
		// and "renderings")
		for (GeneratedCode code : contents) {
			processMultiFiles(engine.split(code.getContent()), code.getMerger());
		}

		for (RenderData renderData : renderings) {
			String text = engine.renderMacro("main", renderData.getAttributes(), new String[] {});
			processMultiFiles(engine.split(text), renderData.getCodeMerger());
		}
	}

	private void processMultiFiles(Map<String, String> contents, CodeMerger codeMerger) {
		if (!contents.isEmpty()) {
			for (Entry<String, String> entry : contents.entrySet()) {
				files.put(entry.getKey(), new GeneratedFile(entry.getKey(), entry.getValue(),
						codeMerger));
			}
		} else {
			logger.error("File name not specified!");
		}
	}

	private void generateFiles() throws JannocessorException {
		logger.info("Generating {} files...", files.size());

		for (Entry<String, GeneratedFile> file : files.entrySet()) {
			generateFile(file.getValue());
		}

		logger.info("Total {} files were generated.", files.size());
	}

	private void generateFile(GeneratedFile file) throws JannocessorException {
		Location location = StandardLocation.SOURCE_OUTPUT;

		String info = fileInfo(location, "", file.getFilename());
		logger.debug("- Generating file: {}", info);

		writeToFile(location, "", file.getFilename(), file.getContent(), file.getMerger());
	}

	private ProcessingContext createProcessingContext() {
		DefaultProcessingContext context = new DefaultProcessingContext();

		context.setEngine(engine);
		context.setLogger(logger);
		context.setElements(elementUtils);
		context.setTypes(typeUtils);
		context.setFiles(files);
		context.setContents(contents);
		context.setProblems(problems);
		context.setFiler(filer);
		context.setRenderer(renderRegister);
		context.setOutputPath(getOutputPath());

		return context;
	}

	private void processElements(Set<? extends TypeElement> annotations, RoundEnvironment env,
			ProcessingContext context) throws JannocessorException {
		// List<Object> facts = new ArrayList<Object>();
		logger.info("Starting processing iteration...");

		Map<String, Set<? extends Element>> annotated = getAnnotatedElements(annotations, env);

		Set<String> processorClasses = new HashSet<String>();
		for (ProcessingConfiguration config : processorsConfig.getConfiguration()) {
			processorClasses.add(config.getProcessor().getClass().getCanonicalName());
		}

		Class<?> hotConfig = Jannocessor.reloadClass("org.jannocessor.config.Processors",
				processorClasses);
		processorsConfig = new ProcessorsConfiguration(hotConfig);

		// construct "root" facts
		// Set<? extends Element> roots = env.getRootElements();
		// for (Element rootElement : roots) {
		// // add new "root" wrapper fact for each root element
		// Root root = new Root(AdapterFactory.getElementModel(rootElement,
		// JavaElement.class,
		// elementUtils, typeUtils));
		// facts.add(root);
		// }

		logger.info("Executing {} annotation processing configurations...");
		for (ProcessingConfiguration config : processorsConfig.getConfiguration()) {
			HashSet<Element> elements = new HashSet<Element>();

			for (Class<? extends Annotation> annotation : config.getAnnotations()) {
				Set<? extends Element> annotatedElements = annotated.get(annotation
						.getCanonicalName());
				if (annotatedElements != null) {
					elements.addAll(annotatedElements);
				}
			}

			PowerList<JavaElement> list = Power.list();

			for (Element element : elements) {
				JavaElement model = AdapterFactory.getElementModel(element, JavaElement.class,
						elementUtils, typeUtils);

				boolean matchedByType = false;
				for (Class<? extends JavaElement> type : config.getTypes()) {
					if (type.isInstance(model)) {
						list.add(model);
						matchedByType = true;
						break;
					}
				}
				
				if (!matchedByType) {
					logger.warn("Didn't match by type the element : " + model);
				}
			}

			CodeProcessor<? extends JavaElement> processor = config.getProcessor();
			logger.info("Invoking processor {} for {} elements", processor, list.size());
			invokeProcessor(processor, list, context);
		}

		logger.info("Finished processing iteration.");
	}

	private Map<String, Set<? extends Element>> getAnnotatedElements(
			Set<? extends TypeElement> annotations, RoundEnvironment env) {
		Map<String, Set<? extends Element>> annotatedElements = new HashMap<String, Set<? extends Element>>();

		for (TypeElement annotation : annotations) {
			String name = annotation.getQualifiedName().toString();
			Set<? extends Element> elements = env.getElementsAnnotatedWith(annotation);

			annotatedElements.put(name, elements);

			logger.info("Total {} elements were annotated with @{}", elements.size(),
					annotation.getSimpleName());
		}

		return annotatedElements;
	}

	@SuppressWarnings("unchecked")
	private <T extends JavaElement> void invokeProcessor(CodeProcessor<T> codeProcessor,
			PowerList<? extends JavaElement> list, ProcessingContext context) {
		codeProcessor.process((PowerList<T>) list, context);
	}

	@Override
	protected Set<String> retrieveSupportedAnnotations() throws JannocessorException {

		Set<String> supportedAnnotations = processorsConfig.getSupportedAnnotations();

		for (String annotation : supportedAnnotations) {
			logger.debug("- Supported annotation: " + annotation);
		}

		return supportedAnnotations;
	}

}

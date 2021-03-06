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

package org.jannocessor.model.bean;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.CodeNode;
import org.jannocessor.model.JavaCodeModel;
import org.jannocessor.model.JavaElement;
import org.jannocessor.model.executable.AbstractJavaExecutable;
import org.jannocessor.model.executable.JavaConstructor;
import org.jannocessor.model.executable.JavaMethod;
import org.jannocessor.model.modifier.AnnotationModifiers;
import org.jannocessor.model.modifier.ClassModifiers;
import org.jannocessor.model.modifier.ConstructorModifiers;
import org.jannocessor.model.modifier.EnumModifiers;
import org.jannocessor.model.modifier.InterfaceModifiers;
import org.jannocessor.model.modifier.MethodModifiers;
import org.jannocessor.model.structure.AbstractJavaStructure;
import org.jannocessor.model.structure.JavaAnnotation;
import org.jannocessor.model.structure.JavaClass;
import org.jannocessor.model.structure.JavaEnum;
import org.jannocessor.model.structure.JavaInterface;
import org.jannocessor.model.structure.JavaMetadata;
import org.jannocessor.model.structure.JavaTypeParameter;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.variable.JavaEnumConstant;
import org.jannocessor.model.variable.JavaField;
import org.jannocessor.model.variable.JavaParameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractModelTest {

	private static Logger log = LoggerFactory.getLogger("TEST");

	private static final int LESS = 1;

	private static final int FEW = 2;

	private static <T> void info(String operation, T[] values, int target) {
		log.debug("%(%): % -> %", new Object[] { operation,
				values.getClass().getComponentType(), values.length, target });
	}

	protected static <T> T[] less(T[] values) {
		info("Less", values, LESS);
		return Arrays.copyOf(values, LESS);
	}

	protected static <T> T[] few(T[] values) {
		info("Few", values, FEW);
		return Arrays.copyOf(values, FEW);
	}

	protected void checkCodeNode(CodeNode codeNode) {
		assertNotNull(codeNode);
		assertTrue(codeNode.getParent() == codeNode.getParent());

		CodeNode clone = codeNode.copy();
		assertTrue(clone != codeNode);
		assertTrue(clone.equals(codeNode));
		assertTrue(codeNode.equals(clone));
	}

	protected void checkCodeModel(JavaCodeModel codeModel) {
		checkCodeNode(codeModel);
		assertNotNull(codeModel.getCode());
	}

	protected void checkElementName(JavaElement element, String name) {
		if (name != null) {
			assertNotNull(element.getName());
			assertEquals(name, element.getName().getText());
		} else {
			assertNull(element.getName());
		}
	}

	protected void checkElement(JavaElement element, String name, JavaType type) {
		checkCodeModel(element);

		checkElementName(element, name);
		assertEquals(type, element.getType());
	}

	protected void checkElement(JavaElement element, String name, Class<?> type) {
		checkCodeModel(element);

		checkElementName(element, name);
		assertEquals(type.getCanonicalName(), element.getType()
				.getCanonicalName());
	}

	protected void checkElement(JavaElement element, JavaElement parent,
			PowerList<JavaElement> children, String name, JavaType type) {
		checkElement(element, name, type);

		assertEquals(parent, element.getParent());
//		FIXME assertEquals(children, element.getChildren());
	}

	protected void checkElement(JavaElement element, JavaElement parent,
			PowerList<JavaElement> children, String name, Class<?> type) {
		checkElement(element, name, type);

		assertEquals(parent, element.getParent());
//		FIXME assertEquals(children, element.getChildren());
	}

	protected void checkLonelyElement(JavaElement element, String name,
			JavaType type) {
		checkElement(element, null, null, name, type);
	}

	protected void checkLonelyElement(JavaElement element, String name,
			Class<?> type) {
		checkElement(element, null, null, name, type);
	}

	protected void checkLonelyElement(JavaElement element) {
		checkElement(element, null, null, null, (JavaType) null);
	}

	protected void checkExecutable(AbstractJavaExecutable executable) {
		checkCodeModel(executable);

		assertNotNull(executable.getBody());
//		FIXME assertEquals(null, executable.getChildren());
	}

	protected void checkConstructor(JavaConstructor constructor,
			ConstructorModifiers modifiers, List<JavaParameter> params,
			List<JavaType> thrownTypes, List<JavaTypeParameter> typeParameters,
			Boolean isVarArgs) {
		checkExecutable(constructor);

		assertEquals(modifiers, constructor.getModifiers());
		assertEquals(params, constructor.getParameters());
		assertEquals(thrownTypes, constructor.getThrownTypes());
		assertEquals(typeParameters, constructor.getTypeParameters());
		assertEquals(isVarArgs, constructor.isVarArgs());
	}

	protected void checkMethod(JavaMethod method, MethodModifiers modifiers,
			JavaType returnType, String name, List<JavaParameter> params,
			List<JavaType> thrownTypes, List<JavaTypeParameter> typeParameters) {
		checkExecutable(method);

		assertEquals(modifiers, method.getModifiers());
		assertEquals(returnType, method.getReturnType());
		checkElementName(method, name);
		assertEquals(params, method.getParameters());
		assertEquals(thrownTypes, method.getThrownTypes());
		assertEquals(typeParameters, method.getTypeParameters());
	}

	private void checkStructural(AbstractJavaStructure type,
			JavaType superclass, List<JavaType> interfaces) {
		checkCodeModel(type);

		assertEquals(superclass, type.getSuperclass());
		assertEquals(interfaces, type.getInterfaces());
	}

	protected void checkClass(JavaClass clazz, ClassModifiers modifiers,
			String name, JavaType superclass, List<JavaType> interfaces,
			List<JavaField> fields, List<JavaConstructor> constructors,
			List<JavaMethod> methods, List<JavaTypeParameter> parameters) {
		checkStructural(clazz, superclass, interfaces);
		checkElementName(clazz, name);

		assertEquals(modifiers, clazz.getModifiers());
		assertEquals(fields, clazz.getFields());
		assertEquals(constructors, clazz.getConstructors());
		assertEquals(methods, clazz.getMethods());
		assertEquals(parameters, clazz.getTypeParameters());
	}

	protected void checkInterface(JavaInterface interfacee,
			InterfaceModifiers modifiers, String name,
			List<JavaType> interfaces, List<JavaField> fields,
			List<JavaMethod> methods, List<JavaTypeParameter> parameters) {
		checkStructural(interfacee, null, interfaces);
		checkElementName(interfacee, name);

		assertEquals(modifiers, interfacee.getModifiers());
		assertEquals(fields, interfacee.getFields());
		assertEquals(methods, interfacee.getMethods());
		assertEquals(parameters, interfacee.getTypeParameters());
	}

	protected void checkEnum(JavaEnum enumm, EnumModifiers modifiers,
			String name, List<JavaType> interfaces,
			List<JavaEnumConstant> values, List<JavaField> fields,
			List<JavaConstructor> constructors, List<JavaMethod> methods) {
		// TODO: should parent be set to null, or Enum?
		checkStructural(enumm, null, interfaces);
		checkElementName(enumm, name);

		assertEquals(modifiers, enumm.getModifiers());
		assertEquals(values, enumm.getValues());
		assertEquals(fields, enumm.getFields());
		assertEquals(constructors, enumm.getConstructors());
		assertEquals(methods, enumm.getMethods());
	}

	protected void checkAnnotation(JavaAnnotation annotation,
			AnnotationModifiers modifiers, String name, List<JavaMethod> methods) {
		// TODO: should interfaces be set to null, or else?
		checkStructural(annotation, null, null);
		checkElementName(annotation, name);

		assertEquals(modifiers, annotation.getModifiers());
		assertEquals(methods, annotation.getMethods());
	}

	protected void checkMetadata(JavaMetadata metadata, JavaType annotation,
			Map<String, ? extends Object> attributes) {
		assertEquals(annotation, metadata.getAnnotation());
		assertEquals(attributes, metadata.getValues());
	}

	protected void checkAllEquall(JavaCodeModel... models) {
		for (JavaCodeModel model1 : models) {
			for (JavaCodeModel model2 : models) {
				assertEquals(model1, model2);
			}
		}
	}

}

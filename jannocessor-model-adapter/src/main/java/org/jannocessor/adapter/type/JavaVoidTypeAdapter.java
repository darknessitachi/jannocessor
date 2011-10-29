/**
 * Copyright 2011 Nikolche Mihajlovski
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jannocessor.adapter.type;

import javax.lang.model.type.NoType;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.CodeNode;
import org.jannocessor.model.type.JavaVoidType;
import org.jannocessor.model.util.ModelUtils;

public class JavaVoidTypeAdapter extends AbstractJavaTypeAdapter implements
		JavaVoidType {

	private static final long serialVersionUID = 8556334335757463508L;
	@SuppressWarnings("unused")
	private final NoType noType;

	public JavaVoidTypeAdapter(NoType noType, Elements elementUtils,
			Types typeUtils) {
		super(noType, elementUtils, typeUtils);

		this.noType = noType;

	}

	@Override
	protected Class<? extends JavaVoidType> getAdaptedInterface() {
		return JavaVoidType.class;
	}

	@Override
	public PowerList<CodeNode> getChildren() {
		return ModelUtils.getChildren(this);
	}

}

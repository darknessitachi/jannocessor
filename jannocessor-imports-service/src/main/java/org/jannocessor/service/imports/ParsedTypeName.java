/**
 * Copyright 2011 jannocessor.org
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

package org.jannocessor.service.imports;

import java.util.List;

import org.apache.commons.lang.StringUtils;

public class ParsedTypeName {

	private final String packageName;
	private final String className;
	private final List<String> params;
	private final int arrayDimensions;

	public ParsedTypeName(String packageName, String className,
			List<String> generics, int arrayDimensions) {
		this.packageName = packageName;
		this.className = className;
		this.params = generics;
		this.arrayDimensions = arrayDimensions;
	}

	public String getPackageName() {
		return packageName;
	}

	public int getArrayDimensions() {
		return arrayDimensions;
	}

	public String getClassName() {
		return className;
	}

	public List<String> getParams() {
		return params;
	}

	@Override
	public String toString() {
		return getGenericType() + getArrayPart() + "<" + params + ">";
	}

	public String getArrayPart() {
		return StringUtils.repeat("[]", arrayDimensions);
	}

	public String getGenericType() {
		return packageName + "." + className;
	}

	public boolean isSimple() {
		return packageName == null && params.isEmpty();
	}
}
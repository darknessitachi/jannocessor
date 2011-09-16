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

package org.jannocessor.model.util;

import org.jannocessor.model.modifier.MethodModifierValue;
import org.jannocessor.model.modifier.MethodModifiers;

public class Methods {

    /** Represents "public" method modifiers. */
    public static final MethodModifiers PUBLIC = Code.methodModifiers(MethodModifierValue.PUBLIC);

    /** Represents "public static" method modifiers. */
    public static final MethodModifiers PUBLIC_STATIC = Code.methodModifiers(MethodModifierValue.PUBLIC, MethodModifierValue.STATIC);

    /** Represents "public static final" method modifiers. */
    public static final MethodModifiers PUBLIC_STATIC_FINAL = Code.methodModifiers(MethodModifierValue.PUBLIC, MethodModifierValue.STATIC, MethodModifierValue.FINAL);

    /** Represents "public static final synchronized" method modifiers. */
    public static final MethodModifiers PUBLIC_STATIC_FINAL_SYNCHRONIZED = Code.methodModifiers(MethodModifierValue.PUBLIC, MethodModifierValue.STATIC, MethodModifierValue.FINAL, MethodModifierValue.SYNCHRONIZED);

    /** Represents "public static final synchronized native" method modifiers. */
    public static final MethodModifiers PUBLIC_STATIC_FINAL_SYNCHRONIZED_NATIVE = Code.methodModifiers(MethodModifierValue.PUBLIC, MethodModifierValue.STATIC, MethodModifierValue.FINAL, MethodModifierValue.SYNCHRONIZED, MethodModifierValue.NATIVE);

    /** Represents "public static final synchronized strictfp" method modifiers. */
    public static final MethodModifiers PUBLIC_STATIC_FINAL_SYNCHRONIZED_STRICTFP = Code.methodModifiers(MethodModifierValue.PUBLIC, MethodModifierValue.STATIC, MethodModifierValue.FINAL, MethodModifierValue.SYNCHRONIZED, MethodModifierValue.STRICTFP);

    /** Represents "public static final native" method modifiers. */
    public static final MethodModifiers PUBLIC_STATIC_FINAL_NATIVE = Code.methodModifiers(MethodModifierValue.PUBLIC, MethodModifierValue.STATIC, MethodModifierValue.FINAL, MethodModifierValue.NATIVE);

    /** Represents "public static final strictfp" method modifiers. */
    public static final MethodModifiers PUBLIC_STATIC_FINAL_STRICTFP = Code.methodModifiers(MethodModifierValue.PUBLIC, MethodModifierValue.STATIC, MethodModifierValue.FINAL, MethodModifierValue.STRICTFP);

    /** Represents "public static synchronized" method modifiers. */
    public static final MethodModifiers PUBLIC_STATIC_SYNCHRONIZED = Code.methodModifiers(MethodModifierValue.PUBLIC, MethodModifierValue.STATIC, MethodModifierValue.SYNCHRONIZED);

    /** Represents "public static synchronized native" method modifiers. */
    public static final MethodModifiers PUBLIC_STATIC_SYNCHRONIZED_NATIVE = Code.methodModifiers(MethodModifierValue.PUBLIC, MethodModifierValue.STATIC, MethodModifierValue.SYNCHRONIZED, MethodModifierValue.NATIVE);

    /** Represents "public static synchronized strictfp" method modifiers. */
    public static final MethodModifiers PUBLIC_STATIC_SYNCHRONIZED_STRICTFP = Code.methodModifiers(MethodModifierValue.PUBLIC, MethodModifierValue.STATIC, MethodModifierValue.SYNCHRONIZED, MethodModifierValue.STRICTFP);

    /** Represents "public static native" method modifiers. */
    public static final MethodModifiers PUBLIC_STATIC_NATIVE = Code.methodModifiers(MethodModifierValue.PUBLIC, MethodModifierValue.STATIC, MethodModifierValue.NATIVE);

    /** Represents "public static strictfp" method modifiers. */
    public static final MethodModifiers PUBLIC_STATIC_STRICTFP = Code.methodModifiers(MethodModifierValue.PUBLIC, MethodModifierValue.STATIC, MethodModifierValue.STRICTFP);

    /** Represents "public final" method modifiers. */
    public static final MethodModifiers PUBLIC_FINAL = Code.methodModifiers(MethodModifierValue.PUBLIC, MethodModifierValue.FINAL);

    /** Represents "public final synchronized" method modifiers. */
    public static final MethodModifiers PUBLIC_FINAL_SYNCHRONIZED = Code.methodModifiers(MethodModifierValue.PUBLIC, MethodModifierValue.FINAL, MethodModifierValue.SYNCHRONIZED);

    /** Represents "public final synchronized native" method modifiers. */
    public static final MethodModifiers PUBLIC_FINAL_SYNCHRONIZED_NATIVE = Code.methodModifiers(MethodModifierValue.PUBLIC, MethodModifierValue.FINAL, MethodModifierValue.SYNCHRONIZED, MethodModifierValue.NATIVE);

    /** Represents "public final synchronized strictfp" method modifiers. */
    public static final MethodModifiers PUBLIC_FINAL_SYNCHRONIZED_STRICTFP = Code.methodModifiers(MethodModifierValue.PUBLIC, MethodModifierValue.FINAL, MethodModifierValue.SYNCHRONIZED, MethodModifierValue.STRICTFP);

    /** Represents "public final native" method modifiers. */
    public static final MethodModifiers PUBLIC_FINAL_NATIVE = Code.methodModifiers(MethodModifierValue.PUBLIC, MethodModifierValue.FINAL, MethodModifierValue.NATIVE);

    /** Represents "public final strictfp" method modifiers. */
    public static final MethodModifiers PUBLIC_FINAL_STRICTFP = Code.methodModifiers(MethodModifierValue.PUBLIC, MethodModifierValue.FINAL, MethodModifierValue.STRICTFP);

    /** Represents "public abstract" method modifiers. */
    public static final MethodModifiers PUBLIC_ABSTRACT = Code.methodModifiers(MethodModifierValue.PUBLIC, MethodModifierValue.ABSTRACT);

    /** Represents "public synchronized" method modifiers. */
    public static final MethodModifiers PUBLIC_SYNCHRONIZED = Code.methodModifiers(MethodModifierValue.PUBLIC, MethodModifierValue.SYNCHRONIZED);

    /** Represents "public synchronized native" method modifiers. */
    public static final MethodModifiers PUBLIC_SYNCHRONIZED_NATIVE = Code.methodModifiers(MethodModifierValue.PUBLIC, MethodModifierValue.SYNCHRONIZED, MethodModifierValue.NATIVE);

    /** Represents "public synchronized strictfp" method modifiers. */
    public static final MethodModifiers PUBLIC_SYNCHRONIZED_STRICTFP = Code.methodModifiers(MethodModifierValue.PUBLIC, MethodModifierValue.SYNCHRONIZED, MethodModifierValue.STRICTFP);

    /** Represents "public native" method modifiers. */
    public static final MethodModifiers PUBLIC_NATIVE = Code.methodModifiers(MethodModifierValue.PUBLIC, MethodModifierValue.NATIVE);

    /** Represents "public strictfp" method modifiers. */
    public static final MethodModifiers PUBLIC_STRICTFP = Code.methodModifiers(MethodModifierValue.PUBLIC, MethodModifierValue.STRICTFP);

    /** Represents "protected" method modifiers. */
    public static final MethodModifiers PROTECTED = Code.methodModifiers(MethodModifierValue.PROTECTED);

    /** Represents "protected static" method modifiers. */
    public static final MethodModifiers PROTECTED_STATIC = Code.methodModifiers(MethodModifierValue.PROTECTED, MethodModifierValue.STATIC);

    /** Represents "protected static final" method modifiers. */
    public static final MethodModifiers PROTECTED_STATIC_FINAL = Code.methodModifiers(MethodModifierValue.PROTECTED, MethodModifierValue.STATIC, MethodModifierValue.FINAL);

    /** Represents "protected static final synchronized" method modifiers. */
    public static final MethodModifiers PROTECTED_STATIC_FINAL_SYNCHRONIZED = Code.methodModifiers(MethodModifierValue.PROTECTED, MethodModifierValue.STATIC, MethodModifierValue.FINAL, MethodModifierValue.SYNCHRONIZED);

    /**
     * Represents "protected static final synchronized native" method modifiers.
     */
    public static final MethodModifiers PROTECTED_STATIC_FINAL_SYNCHRONIZED_NATIVE = Code.methodModifiers(MethodModifierValue.PROTECTED, MethodModifierValue.STATIC, MethodModifierValue.FINAL, MethodModifierValue.SYNCHRONIZED, MethodModifierValue.NATIVE);

    /**
     * Represents "protected static final synchronized strictfp" method
     * modifiers.
     */
    public static final MethodModifiers PROTECTED_STATIC_FINAL_SYNCHRONIZED_STRICTFP = Code.methodModifiers(MethodModifierValue.PROTECTED, MethodModifierValue.STATIC, MethodModifierValue.FINAL, MethodModifierValue.SYNCHRONIZED, MethodModifierValue.STRICTFP);

    /** Represents "protected static final native" method modifiers. */
    public static final MethodModifiers PROTECTED_STATIC_FINAL_NATIVE = Code.methodModifiers(MethodModifierValue.PROTECTED, MethodModifierValue.STATIC, MethodModifierValue.FINAL, MethodModifierValue.NATIVE);

    /** Represents "protected static final strictfp" method modifiers. */
    public static final MethodModifiers PROTECTED_STATIC_FINAL_STRICTFP = Code.methodModifiers(MethodModifierValue.PROTECTED, MethodModifierValue.STATIC, MethodModifierValue.FINAL, MethodModifierValue.STRICTFP);

    /** Represents "protected static synchronized" method modifiers. */
    public static final MethodModifiers PROTECTED_STATIC_SYNCHRONIZED = Code.methodModifiers(MethodModifierValue.PROTECTED, MethodModifierValue.STATIC, MethodModifierValue.SYNCHRONIZED);

    /** Represents "protected static synchronized native" method modifiers. */
    public static final MethodModifiers PROTECTED_STATIC_SYNCHRONIZED_NATIVE = Code.methodModifiers(MethodModifierValue.PROTECTED, MethodModifierValue.STATIC, MethodModifierValue.SYNCHRONIZED, MethodModifierValue.NATIVE);

    /** Represents "protected static synchronized strictfp" method modifiers. */
    public static final MethodModifiers PROTECTED_STATIC_SYNCHRONIZED_STRICTFP = Code.methodModifiers(MethodModifierValue.PROTECTED, MethodModifierValue.STATIC, MethodModifierValue.SYNCHRONIZED, MethodModifierValue.STRICTFP);

    /** Represents "protected static native" method modifiers. */
    public static final MethodModifiers PROTECTED_STATIC_NATIVE = Code.methodModifiers(MethodModifierValue.PROTECTED, MethodModifierValue.STATIC, MethodModifierValue.NATIVE);

    /** Represents "protected static strictfp" method modifiers. */
    public static final MethodModifiers PROTECTED_STATIC_STRICTFP = Code.methodModifiers(MethodModifierValue.PROTECTED, MethodModifierValue.STATIC, MethodModifierValue.STRICTFP);

    /** Represents "protected final" method modifiers. */
    public static final MethodModifiers PROTECTED_FINAL = Code.methodModifiers(MethodModifierValue.PROTECTED, MethodModifierValue.FINAL);

    /** Represents "protected final synchronized" method modifiers. */
    public static final MethodModifiers PROTECTED_FINAL_SYNCHRONIZED = Code.methodModifiers(MethodModifierValue.PROTECTED, MethodModifierValue.FINAL, MethodModifierValue.SYNCHRONIZED);

    /** Represents "protected final synchronized native" method modifiers. */
    public static final MethodModifiers PROTECTED_FINAL_SYNCHRONIZED_NATIVE = Code.methodModifiers(MethodModifierValue.PROTECTED, MethodModifierValue.FINAL, MethodModifierValue.SYNCHRONIZED, MethodModifierValue.NATIVE);

    /** Represents "protected final synchronized strictfp" method modifiers. */
    public static final MethodModifiers PROTECTED_FINAL_SYNCHRONIZED_STRICTFP = Code.methodModifiers(MethodModifierValue.PROTECTED, MethodModifierValue.FINAL, MethodModifierValue.SYNCHRONIZED, MethodModifierValue.STRICTFP);

    /** Represents "protected final native" method modifiers. */
    public static final MethodModifiers PROTECTED_FINAL_NATIVE = Code.methodModifiers(MethodModifierValue.PROTECTED, MethodModifierValue.FINAL, MethodModifierValue.NATIVE);

    /** Represents "protected final strictfp" method modifiers. */
    public static final MethodModifiers PROTECTED_FINAL_STRICTFP = Code.methodModifiers(MethodModifierValue.PROTECTED, MethodModifierValue.FINAL, MethodModifierValue.STRICTFP);

    /** Represents "protected abstract" method modifiers. */
    public static final MethodModifiers PROTECTED_ABSTRACT = Code.methodModifiers(MethodModifierValue.PROTECTED, MethodModifierValue.ABSTRACT);

    /** Represents "protected synchronized" method modifiers. */
    public static final MethodModifiers PROTECTED_SYNCHRONIZED = Code.methodModifiers(MethodModifierValue.PROTECTED, MethodModifierValue.SYNCHRONIZED);

    /** Represents "protected synchronized native" method modifiers. */
    public static final MethodModifiers PROTECTED_SYNCHRONIZED_NATIVE = Code.methodModifiers(MethodModifierValue.PROTECTED, MethodModifierValue.SYNCHRONIZED, MethodModifierValue.NATIVE);

    /** Represents "protected synchronized strictfp" method modifiers. */
    public static final MethodModifiers PROTECTED_SYNCHRONIZED_STRICTFP = Code.methodModifiers(MethodModifierValue.PROTECTED, MethodModifierValue.SYNCHRONIZED, MethodModifierValue.STRICTFP);

    /** Represents "protected native" method modifiers. */
    public static final MethodModifiers PROTECTED_NATIVE = Code.methodModifiers(MethodModifierValue.PROTECTED, MethodModifierValue.NATIVE);

    /** Represents "protected strictfp" method modifiers. */
    public static final MethodModifiers PROTECTED_STRICTFP = Code.methodModifiers(MethodModifierValue.PROTECTED, MethodModifierValue.STRICTFP);

    /** Represents "private" method modifiers. */
    public static final MethodModifiers PRIVATE = Code.methodModifiers(MethodModifierValue.PRIVATE);

    /** Represents "private static" method modifiers. */
    public static final MethodModifiers PRIVATE_STATIC = Code.methodModifiers(MethodModifierValue.PRIVATE, MethodModifierValue.STATIC);

    /** Represents "private static final" method modifiers. */
    public static final MethodModifiers PRIVATE_STATIC_FINAL = Code.methodModifiers(MethodModifierValue.PRIVATE, MethodModifierValue.STATIC, MethodModifierValue.FINAL);

    /** Represents "private static final synchronized" method modifiers. */
    public static final MethodModifiers PRIVATE_STATIC_FINAL_SYNCHRONIZED = Code.methodModifiers(MethodModifierValue.PRIVATE, MethodModifierValue.STATIC, MethodModifierValue.FINAL, MethodModifierValue.SYNCHRONIZED);

    /** Represents "private static final synchronized native" method modifiers. */
    public static final MethodModifiers PRIVATE_STATIC_FINAL_SYNCHRONIZED_NATIVE = Code.methodModifiers(MethodModifierValue.PRIVATE, MethodModifierValue.STATIC, MethodModifierValue.FINAL, MethodModifierValue.SYNCHRONIZED, MethodModifierValue.NATIVE);

    /**
     * Represents "private static final synchronized strictfp" method modifiers.
     */
    public static final MethodModifiers PRIVATE_STATIC_FINAL_SYNCHRONIZED_STRICTFP = Code.methodModifiers(MethodModifierValue.PRIVATE, MethodModifierValue.STATIC, MethodModifierValue.FINAL, MethodModifierValue.SYNCHRONIZED, MethodModifierValue.STRICTFP);

    /** Represents "private static final native" method modifiers. */
    public static final MethodModifiers PRIVATE_STATIC_FINAL_NATIVE = Code.methodModifiers(MethodModifierValue.PRIVATE, MethodModifierValue.STATIC, MethodModifierValue.FINAL, MethodModifierValue.NATIVE);

    /** Represents "private static final strictfp" method modifiers. */
    public static final MethodModifiers PRIVATE_STATIC_FINAL_STRICTFP = Code.methodModifiers(MethodModifierValue.PRIVATE, MethodModifierValue.STATIC, MethodModifierValue.FINAL, MethodModifierValue.STRICTFP);

    /** Represents "private static synchronized" method modifiers. */
    public static final MethodModifiers PRIVATE_STATIC_SYNCHRONIZED = Code.methodModifiers(MethodModifierValue.PRIVATE, MethodModifierValue.STATIC, MethodModifierValue.SYNCHRONIZED);

    /** Represents "private static synchronized native" method modifiers. */
    public static final MethodModifiers PRIVATE_STATIC_SYNCHRONIZED_NATIVE = Code.methodModifiers(MethodModifierValue.PRIVATE, MethodModifierValue.STATIC, MethodModifierValue.SYNCHRONIZED, MethodModifierValue.NATIVE);

    /** Represents "private static synchronized strictfp" method modifiers. */
    public static final MethodModifiers PRIVATE_STATIC_SYNCHRONIZED_STRICTFP = Code.methodModifiers(MethodModifierValue.PRIVATE, MethodModifierValue.STATIC, MethodModifierValue.SYNCHRONIZED, MethodModifierValue.STRICTFP);

    /** Represents "private static native" method modifiers. */
    public static final MethodModifiers PRIVATE_STATIC_NATIVE = Code.methodModifiers(MethodModifierValue.PRIVATE, MethodModifierValue.STATIC, MethodModifierValue.NATIVE);

    /** Represents "private static strictfp" method modifiers. */
    public static final MethodModifiers PRIVATE_STATIC_STRICTFP = Code.methodModifiers(MethodModifierValue.PRIVATE, MethodModifierValue.STATIC, MethodModifierValue.STRICTFP);

    /** Represents "private final" method modifiers. */
    public static final MethodModifiers PRIVATE_FINAL = Code.methodModifiers(MethodModifierValue.PRIVATE, MethodModifierValue.FINAL);

    /** Represents "private final synchronized" method modifiers. */
    public static final MethodModifiers PRIVATE_FINAL_SYNCHRONIZED = Code.methodModifiers(MethodModifierValue.PRIVATE, MethodModifierValue.FINAL, MethodModifierValue.SYNCHRONIZED);

    /** Represents "private final synchronized native" method modifiers. */
    public static final MethodModifiers PRIVATE_FINAL_SYNCHRONIZED_NATIVE = Code.methodModifiers(MethodModifierValue.PRIVATE, MethodModifierValue.FINAL, MethodModifierValue.SYNCHRONIZED, MethodModifierValue.NATIVE);

    /** Represents "private final synchronized strictfp" method modifiers. */
    public static final MethodModifiers PRIVATE_FINAL_SYNCHRONIZED_STRICTFP = Code.methodModifiers(MethodModifierValue.PRIVATE, MethodModifierValue.FINAL, MethodModifierValue.SYNCHRONIZED, MethodModifierValue.STRICTFP);

    /** Represents "private final native" method modifiers. */
    public static final MethodModifiers PRIVATE_FINAL_NATIVE = Code.methodModifiers(MethodModifierValue.PRIVATE, MethodModifierValue.FINAL, MethodModifierValue.NATIVE);

    /** Represents "private final strictfp" method modifiers. */
    public static final MethodModifiers PRIVATE_FINAL_STRICTFP = Code.methodModifiers(MethodModifierValue.PRIVATE, MethodModifierValue.FINAL, MethodModifierValue.STRICTFP);

    /** Represents "private synchronized" method modifiers. */
    public static final MethodModifiers PRIVATE_SYNCHRONIZED = Code.methodModifiers(MethodModifierValue.PRIVATE, MethodModifierValue.SYNCHRONIZED);

    /** Represents "private synchronized native" method modifiers. */
    public static final MethodModifiers PRIVATE_SYNCHRONIZED_NATIVE = Code.methodModifiers(MethodModifierValue.PRIVATE, MethodModifierValue.SYNCHRONIZED, MethodModifierValue.NATIVE);

    /** Represents "private synchronized strictfp" method modifiers. */
    public static final MethodModifiers PRIVATE_SYNCHRONIZED_STRICTFP = Code.methodModifiers(MethodModifierValue.PRIVATE, MethodModifierValue.SYNCHRONIZED, MethodModifierValue.STRICTFP);

    /** Represents "private native" method modifiers. */
    public static final MethodModifiers PRIVATE_NATIVE = Code.methodModifiers(MethodModifierValue.PRIVATE, MethodModifierValue.NATIVE);

    /** Represents "private strictfp" method modifiers. */
    public static final MethodModifiers PRIVATE_STRICTFP = Code.methodModifiers(MethodModifierValue.PRIVATE, MethodModifierValue.STRICTFP);

    /** Represents "static" method modifiers. */
    public static final MethodModifiers STATIC = Code.methodModifiers(MethodModifierValue.STATIC);

    /** Represents "static final" method modifiers. */
    public static final MethodModifiers STATIC_FINAL = Code.methodModifiers(MethodModifierValue.STATIC, MethodModifierValue.FINAL);

    /** Represents "static final synchronized" method modifiers. */
    public static final MethodModifiers STATIC_FINAL_SYNCHRONIZED = Code.methodModifiers(MethodModifierValue.STATIC, MethodModifierValue.FINAL, MethodModifierValue.SYNCHRONIZED);

    /** Represents "static final synchronized native" method modifiers. */
    public static final MethodModifiers STATIC_FINAL_SYNCHRONIZED_NATIVE = Code.methodModifiers(MethodModifierValue.STATIC, MethodModifierValue.FINAL, MethodModifierValue.SYNCHRONIZED, MethodModifierValue.NATIVE);

    /** Represents "static final synchronized strictfp" method modifiers. */
    public static final MethodModifiers STATIC_FINAL_SYNCHRONIZED_STRICTFP = Code.methodModifiers(MethodModifierValue.STATIC, MethodModifierValue.FINAL, MethodModifierValue.SYNCHRONIZED, MethodModifierValue.STRICTFP);

    /** Represents "static final native" method modifiers. */
    public static final MethodModifiers STATIC_FINAL_NATIVE = Code.methodModifiers(MethodModifierValue.STATIC, MethodModifierValue.FINAL, MethodModifierValue.NATIVE);

    /** Represents "static final strictfp" method modifiers. */
    public static final MethodModifiers STATIC_FINAL_STRICTFP = Code.methodModifiers(MethodModifierValue.STATIC, MethodModifierValue.FINAL, MethodModifierValue.STRICTFP);

    /** Represents "static synchronized" method modifiers. */
    public static final MethodModifiers STATIC_SYNCHRONIZED = Code.methodModifiers(MethodModifierValue.STATIC, MethodModifierValue.SYNCHRONIZED);

    /** Represents "static synchronized native" method modifiers. */
    public static final MethodModifiers STATIC_SYNCHRONIZED_NATIVE = Code.methodModifiers(MethodModifierValue.STATIC, MethodModifierValue.SYNCHRONIZED, MethodModifierValue.NATIVE);

    /** Represents "static synchronized strictfp" method modifiers. */
    public static final MethodModifiers STATIC_SYNCHRONIZED_STRICTFP = Code.methodModifiers(MethodModifierValue.STATIC, MethodModifierValue.SYNCHRONIZED, MethodModifierValue.STRICTFP);

    /** Represents "static native" method modifiers. */
    public static final MethodModifiers STATIC_NATIVE = Code.methodModifiers(MethodModifierValue.STATIC, MethodModifierValue.NATIVE);

    /** Represents "static strictfp" method modifiers. */
    public static final MethodModifiers STATIC_STRICTFP = Code.methodModifiers(MethodModifierValue.STATIC, MethodModifierValue.STRICTFP);

    /** Represents "final" method modifiers. */
    public static final MethodModifiers FINAL = Code.methodModifiers(MethodModifierValue.FINAL);

    /** Represents "final synchronized" method modifiers. */
    public static final MethodModifiers FINAL_SYNCHRONIZED = Code.methodModifiers(MethodModifierValue.FINAL, MethodModifierValue.SYNCHRONIZED);

    /** Represents "final synchronized native" method modifiers. */
    public static final MethodModifiers FINAL_SYNCHRONIZED_NATIVE = Code.methodModifiers(MethodModifierValue.FINAL, MethodModifierValue.SYNCHRONIZED, MethodModifierValue.NATIVE);

    /** Represents "final synchronized strictfp" method modifiers. */
    public static final MethodModifiers FINAL_SYNCHRONIZED_STRICTFP = Code.methodModifiers(MethodModifierValue.FINAL, MethodModifierValue.SYNCHRONIZED, MethodModifierValue.STRICTFP);

    /** Represents "final native" method modifiers. */
    public static final MethodModifiers FINAL_NATIVE = Code.methodModifiers(MethodModifierValue.FINAL, MethodModifierValue.NATIVE);

    /** Represents "final strictfp" method modifiers. */
    public static final MethodModifiers FINAL_STRICTFP = Code.methodModifiers(MethodModifierValue.FINAL, MethodModifierValue.STRICTFP);

    /** Represents "abstract" method modifiers. */
    public static final MethodModifiers ABSTRACT = Code.methodModifiers(MethodModifierValue.ABSTRACT);

    /** Represents "synchronized" method modifiers. */
    public static final MethodModifiers SYNCHRONIZED = Code.methodModifiers(MethodModifierValue.SYNCHRONIZED);

    /** Represents "synchronized native" method modifiers. */
    public static final MethodModifiers SYNCHRONIZED_NATIVE = Code.methodModifiers(MethodModifierValue.SYNCHRONIZED, MethodModifierValue.NATIVE);

    /** Represents "synchronized strictfp" method modifiers. */
    public static final MethodModifiers SYNCHRONIZED_STRICTFP = Code.methodModifiers(MethodModifierValue.SYNCHRONIZED, MethodModifierValue.STRICTFP);

    /** Represents "native" method modifiers. */
    public static final MethodModifiers NATIVE = Code.methodModifiers(MethodModifierValue.NATIVE);

    /** Represents "strictfp" method modifiers. */
    public static final MethodModifiers STRICTFP = Code.methodModifiers(MethodModifierValue.STRICTFP);

}
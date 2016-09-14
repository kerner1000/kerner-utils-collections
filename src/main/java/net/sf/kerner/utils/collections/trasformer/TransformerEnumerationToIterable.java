/*******************************************************************************
 * Copyright (c) 2015 Alexander Kerner. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package net.sf.kerner.utils.collections.trasformer;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import net.sf.kerner.utils.transformer.Transformer;

public class TransformerEnumerationToIterable<T> implements Transformer<Enumeration<T>, Iterable<T>> {

    public Iterable<T> transform(Enumeration<T> enumeration) {
	final List<T> v = new ArrayList<T>();
	while (enumeration.hasMoreElements()) {
	    v.add(enumeration.nextElement());
	}
	return v;
    }

}

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

import java.util.Enumeration;
import java.util.Iterator;

import net.sf.kerner.utils.transformer.Transformer;

public class TransformerEnumerationToIterator<T> implements Transformer<Enumeration<T>, Iterator<T>> {

    public Iterator<T> transform(Enumeration<T> enumeration) {
	return new TransformerEnumerationToIterable<T>().transform(enumeration).iterator();
    }

}

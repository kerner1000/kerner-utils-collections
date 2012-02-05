/**********************************************************************
Copyright (c) 2009-2010 Alexander Kerner. All rights reserved.
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 ***********************************************************************/

package net.sf.kerner.utils.collections;

import java.util.Collection;

/**
 * 
 * A {@code CollectionTransformer} converts one object of type
 * {@code Collection<? extends T>} to another object of type
 * {@code Collection<? super V>}.
 * 
 * <p>
 * <b>Example:</b><br>
 * 
 * </p>
 * <p>
 * 
 * <pre>
 * TODO example
 * </pre>
 * 
 * </p>
 * 
 * @author <a href="mailto:alex.kerner.24@googlemail.com">Alexander Kerner</a>
 * @version 2011-05-11
 * 
 * @param <T>
 *            type of elements in input collection
 * @param <V>
 *            type of elements in output collection
 */
public interface CollectionTransformer<T, V> {

	Collection<V> transformCollection(Collection<? extends T> element);

}

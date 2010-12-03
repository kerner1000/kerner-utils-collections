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

import net.sf.kerner.utils.factory.Factory;

/**
 * 
 * A {@code CollectionFactory} provides factory methods to retrieve all kind of
 * direct and indirect implementations of {@link java.util.Collection
 * Collection}.
 * 
 * @autor <a href="mailto:alex.kerner.24@googlemail.com">Alexander Kerner</a>
 * @version 2010-12-03
 * @param E
 *            type of elements within the collection
 * 
 */
public interface CollectionFactory<E> extends Factory<Collection<? extends E>> {

	/**
	 * 
	 * Get a new implementation for specified {@code Collection}.
	 * 
	 * @return new {@code Collection}
	 */
	Collection<E> create();

	/**
	 * 
	 * Get a new implementation for specified {@code Collection} containing all
	 * given elements.
	 * 
	 * @param elements
	 *            that are contained in new collection
	 * @return new {@code Collection}
	 */
	Collection<E> createCollection(Collection<? extends E> elements);

}

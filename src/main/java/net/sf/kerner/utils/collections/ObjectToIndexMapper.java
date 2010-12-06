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
import java.util.NoSuchElementException;
import java.util.Set;

/**
 * 
 * 
 * An {@code ObjectToIndexMapper} establishes a mapping between any collection of objects and a {@link java.util.List List}'s integer indices.
 * <p>
 * Given a collection of objects, e.g. following set of strings:
 * </p>
 * <pre>
 * {one, two, three, four}
 * </pre>
 * And a given list with following elements:
 * <pre>
 * {blue, red, black, green}
 * </pre> 
 * Access to this list's elements can be more intuitive accessing the elements by an object-based index:
 * <pre>
 * List colors = new ArrayList(){{blue, red, black, green}};
 * ObjectToIndexMapper mapper = new ObjectToIndexMapperImpl(colors);
 * assertEquals(blue, colors.get(mapper.get(one)));
 * ...
 * </pre>
 * <p>
 * <b>Example:</b>
 * 
 * <pre>
 * TODO example
 * </pre>
 * 
 * </p>
 * 
 * @author <a href="mailto:alex.kerner.24@googlemail.com">Alexander Kerner</a>
 * @version 2010-12-03
 * @see java.util.Collection
 * @see java.util.List
 * @see java.util.Map
 * 
 */
public interface ObjectToIndexMapper {
	
	/**
	 * 
	 * Check weather given object maps to any index.
	 *
	 * @param key object that is checked to be a valid key in this {@code ObjectToIndexMapper}
	 * @return true, if given object is a valid key; false otherwise
	 */
	boolean containsKey(Object key);
	
	/**
	 * 
	 * Check weather given index is mapped by any object.
	 *
	 * @param index index that is checked to be a valid value in this {@code ObjectToIndexMapper}
	 * @return true, if given index is a valid value; false otherwise
	 */
	boolean containsValue(int index);

	/**
	 * 
	 * Get index that is mapped by given object identifier.
	 *
	 * @param key object that maps to index
	 * @return index that is mapped
	 * 
	 * @throws NoSuchElementException if key is not registered to this {@code ObjectToIndexMapper}
	 */
	int get(Object key);

	/**
	 * 
	 * Get object identifier that maps to given index.
	 *
	 * @param index index for which mapping object is returned
	 * @return object that maps to given index
	 */
	Object getValue(int index);
	
	/**
	 * 
	 * Get a {@code Collection} that contains all values of this {@code ObjectToIndexMapper}, meaning all indices that are mapped by objects.
	 *
	 * @return a {@code Collection} that contains all values of this {@code ObjectToIndexMapper}
	 */
	Collection<? extends Integer> values();

	/**
	 * 
	 * Get a {@code Set} that contains all keys of this {@code ObjectToIndexMapper}, meaning all objects that map to indices.
	 *
	 * @return a {@code Set} that contains all keys of this {@code ObjectToIndexMapper}
	 */
	Set<? extends Object> keySet();

}

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

package net.sf.kerner.utils.collections.map;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/**
 * 
 * Utility class for {@link java.util.Map Map} related stuff.
 * 
 * @author <a href="mailto:alex.kerner.24@googlemail.com">Alexander Kerner</a>
 * @version 2010-12-03
 * 
 */
public class MapUtils {

	private MapUtils() {
	}

	/**
	 * 
	 * Initialize given {@code Map} with given keys and given values. <br>
	 * After initialization, {@code Map} will contain all given keys. If
	 * {@code number of values >= number of keys}, every given key will map to
	 * one specific value. <br>
	 * Mapping will happen index-based, which means that {@code keys[i]} is
	 * mapped to {@code values[i]}.<br>
	 * If there are more keys than values, left-over keys will map to a null
	 * value, if underlying map allows this.
	 * 
	 * @param <K>
	 *            type of keys
	 * @param <V>
	 *            type of values
	 * @param map
	 *            {@code Map} to initialize
	 * @param keys
	 *            keys which will map to values
	 * @param values
	 *            values which are mapped by keys
	 * @param clean
	 *            if {@code true}, clear given {@code Map} before initializing
	 * 
	 * @see java.util.Map
	 * @see java.util.Collection
	 */
	public static <K, V> void initMapWithValues(Map<K, V> map,
			Collection<? extends K> keys, Collection<? extends V> values,
			boolean clean) {
		if (clean)
			map.clear();
		final Iterator<? extends V> valIt = values.iterator();
		for (K k : keys) {
			if (valIt.hasNext())
				map.put(k, valIt.next());
			else
				map.put(k, null);
		}
	}

	/**
	 * The same as {@code #initMapWithValues(map, keys, values, true)}
	 */
	public static <M, V> void initMapWithValues(Map<M, V> map,
			Collection<? extends M> keys, Collection<? extends V> values) {
		initMapWithValues(map, keys, values, true);
	}

}

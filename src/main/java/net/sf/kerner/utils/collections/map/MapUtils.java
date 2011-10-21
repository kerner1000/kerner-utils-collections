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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import net.sf.kerner.utils.Utils;
import net.sf.kerner.utils.collections.CollectionFactory;
import net.sf.kerner.utils.collections.list.impl.ArrayListFactory;
import net.sf.kerner.utils.counter.Counter;

/**
 * 
 * Utility class for {@link java.util.Map Map} related stuff.
 * 
 * @author <a href="mailto:alex.kerner.24@googlemail.com">Alexander Kerner</a>
 * @version 2011-05-18
 * 
 */
public class MapUtils {

	private MapUtils() {
	}

	public static <K, V> void initMapWithValue(Map<K, V> map, Collection<? extends K> keys,
			V value, boolean clean) {
		if (clean)
			map.clear();
		for (K k : keys) {
			map.put(k, value);
		}
	}

	public static <K, V> void initMapWithValue(Map<K, V> map, Collection<? extends K> keys, V value) {
		initMapWithValue(map, keys, value, true);
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
	public static <K, V> void initMapWithValues(Map<K, V> map, Collection<? extends K> keys,
			Collection<? extends V> values, boolean clean) {
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
	public static <M, V> void initMapWithValues(Map<M, V> map, Collection<? extends M> keys,
			Collection<? extends V> values) {
		initMapWithValues(map, keys, values, true);
	}

	/**
	 * 
	 * 
	 * Given a {@link java.util.Map Map} of collections, add the given element
	 * to the {@link java.util.Collection Collection} associated with given key.
	 * If for this key is no {@code Collection} registered, a new one will be
	 * created. The given element will be then added to this new
	 * {@code Collection}. The new {@code Collection} will be associated with
	 * given key.
	 * <p>
	 * Element that is added may be null, if underlying collection allows null
	 * elements.
	 * </p>
	 * 
	 * @param <M>
	 *            type of keys in given {@code Map}
	 * @param <E>
	 *            type of values in {@code Collection}s contained in given
	 *            {@code Map}
	 * @param map
	 *            {@code Map} that contains {@code Collection} to which element
	 *            is added
	 * @param key
	 *            key for {@code Collection} to which element is added
	 * @param element
	 *            element that is added
	 * @param factory
	 *            {@code CollectionFactory} that is used to create a new
	 *            {@code Collection} if there is no value for given key yet
	 * 
	 * @see java.util.Map Map
	 * @see java.util.Collection Collection
	 * @see net.sf.kerner.utils.collections.CollectionFactory CollectionFactory
	 * 
	 * @throws NullPointerException
	 *             if {@code map} or {@code key} is null
	 */
	public static <M, E> void addToCollectionsMap(Map<M, Collection<E>> map, M key, E element,
			CollectionFactory<E> factory) {
		Utils.checkForNull(map, factory);
		Collection<E> col = map.get(key);
		if (col == null) {
			col = factory.createCollection();
			map.put(key, col);
		}
		col.add(element);
	}

	/**
	 * 
	 * 
	 * Given a {@link java.util.Map Map} of collections, add the given element
	 * to the {@link java.util.Collection Collection} associated with given key.
	 * If for this key is no {@code Collection} registered, a new one will be
	 * created. The given element will be then added to this new
	 * {@code Collection}. The new {@code Collection} will be associated with
	 * given key.
	 * <p>
	 * Element that is added may be null, if underlying collection allows null
	 * elements.
	 * </p>
	 * 
	 * @param <M>
	 *            type of keys in given {@code Map}
	 * @param <E>
	 *            type of values in {@code Collection}s contained in given
	 *            {@code Map}
	 * @param map
	 *            {@code Map} that contains {@code Collection} to which element
	 *            is added
	 * @param key
	 *            key for {@code Collection} to which element is added
	 * @param element
	 *            element that is added
	 * 
	 * @see java.util.Map Map
	 * @see java.util.Collection Collection
	 * 
	 * 
	 * @throws NullPointerException
	 *             if {@code map} or {@code key} is null
	 */
	public static <M, E> void addToCollectionsMap(Map<M, Collection<E>> map, M key, E element) {
		Utils.checkForNull(map, key);
		addToCollectionsMap(map, key, element, new ArrayListFactory<E>());
	}

	/**
	 * 
	 * Reduce the number of elements in given {@link java.uitl.Map Map} to at
	 * most given size.
	 * 
	 * @param <K>
	 *            type of keys in given {@code Map}
	 * @param <V>
	 *            type of values in given {@code Map}
	 * @param map
	 *            {@code Map} that is trimmed
	 * @param factory
	 *            {@link net.sf.kerner.utils.factory.Factory Factory} that is
	 *            used to instantiate returning {@code Map}
	 * @param size
	 *            number of elements returning [@code Map} contains (at most)
	 * @return the new {@code Map} that has been trimmed
	 */
	public static <K, V> Map<K, V> trimMapToSize(Map<K, V> map, MapFactory<K, V> factory, int size) {
		Utils.checkForNull(map, factory);
		if (size < 1 || map.size() <= size)
			return map;
		final Map<K, V> result = factory.create();
		final Counter c = new Counter();
		for (Entry<K, V> e : map.entrySet()) {
			if (c.getCount() > size) {
				break;
			}
			result.put(e.getKey(), e.getValue());
			c.count();
		}
		return result;
	}

	public static <K, V> Map<V, K> invert(Map<K, V> map, MapFactory<V, K> factory) {
		Utils.checkForNull(map, factory);
		final Map<V, K> result = factory.create();
		for (Entry<K, V> e : map.entrySet()) {
			result.put(e.getValue(), e.getKey());
		}
		return result;
	}

	public static <K, V> Map<K, V> sort(Map<K, V> map,
			MapFactory<K, V> factory, Comparator<Map.Entry<K, V>> c) {
		List<Map.Entry<K, V>> list = new ArrayList<Map.Entry<K, V>>(map.entrySet());
		Collections.sort(list, c);
		Map<K, V> result = factory.create();
		for (Map.Entry<K, V> entry : list) {
			result.put(entry.getKey(), entry.getValue());
		}
		return result;
	}
	
	public static <K, V> Map<K, V> sortByValue(final Map<K, V> map,
			final MapFactory<K, V> factory, final Comparator<? super V> c) {
		return sort(map, factory, new Comparator<Entry<K, V>>(){
			public int compare(Entry<K, V> o1, Entry<K, V> o2) {
				return c.compare(o1.getValue(), o2.getValue());
			}});
	}

}

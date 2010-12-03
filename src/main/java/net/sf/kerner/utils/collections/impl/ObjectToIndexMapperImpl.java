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

package net.sf.kerner.utils.collections.impl;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;

import net.sf.kerner.utils.collections.ObjectToIndexMapper;
import net.sf.kerner.utils.collections.map.MapUtils;

/**
 * 
 * Default implementation for
 * {@link net.sf.kerner.utils.collections.ObjectToIndexMapper
 * ObjectToIndexMapper}.
 * 
 * @author <a href="mailto:alex.kerner.24@googlemail.com">Alexander Kerner</a>
 * @version 2010-12-03
 * 
 */
public class ObjectToIndexMapperImpl implements ObjectToIndexMapper {

	// Field //

	/**
	 * 
	 */
	protected final Map<Object, Integer> map = new LinkedHashMap<Object, Integer>();

	// Constructor //

	/**
	 * 
	 */
	public ObjectToIndexMapperImpl(Set<? extends Object> keys) {
		final Collection<Integer> values = new LinkedHashSet<Integer>();
		synchronized (ObjectToIndexMapperImpl.class) {
			for (int i = 0; i < keys.size(); i++) {
				values.add(Integer.valueOf(i));
			}
			MapUtils.initMapWithValues(map, keys, values);
		}
	}

	// Private //

	// Protected //

	protected void checkIndex(Object key) {
		if (map.containsKey(key)) {
			// all good
		} else
			throw new NoSuchElementException("no element for row index [" + key
					+ "]");
	}

	// Public //

	// Override //

	@Override
	public String toString() {
		return map.toString();
	}

	// Implement //

	/**
	 * 
	 */
	public int get(Object key) {
		final Integer result = map.get(key);
		if (result != null) {
			return result;
		} else
			throw new NoSuchElementException("no element for row index [" + key
					+ "]");
	}

	public Object getValue(int index) {
		for (Entry<Object, Integer> e : map.entrySet()) {
			if (e.getValue().equals(Integer.valueOf(index)))
				return e.getKey();
		}
		throw new NoSuchElementException("no element for row index [" + index
				+ "]");
	}

	public boolean containsKey(Object key) {
		return map.containsKey(key);
	}

	public boolean containsValue(int index) {
		return map.containsValue(Integer.valueOf(index));
	}

	public Collection<? extends Integer> values() {
		return map.values();
	}

	public Set<? extends Object> keySet() {
		return map.keySet();
	}

}

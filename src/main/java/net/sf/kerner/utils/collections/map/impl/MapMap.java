package net.sf.kerner.utils.collections.map.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import net.sf.kerner.utils.collections.map.FactoryMap;
import net.sf.kerner.utils.collections.map.MapUtils;

public class MapMap<T, K, V> {

	private final Map<T, Map<K, V>> map;

	private final FactoryMap<K, V> factory;

	public MapMap(Map<T, Map<K, V>> map, FactoryMap<K, V> factory) {
		this.map = map;
		this.factory = factory;
	}

	public MapMap(Map<T, Map<K, V>> map) {
		this(map, new LinkedHashMapFactory<K, V>());
	}

	public MapMap() {
		this(new LinkedHashMap<T, Map<K, V>>(), new LinkedHashMapFactory<K, V>());
	}

	/**
	 * 
	 * TODO description
	 * 
	 * @return number of key1 to map mappings
	 */
	public int size1() {
		return map.size();
	}

	/**
	 * 
	 * TODO description
	 * 
	 * @return number of key2 value mappings
	 */
	public int size2() {
		int size = 0;
		for (Entry<T, Map<K, V>> e : map.entrySet()) {
			size += e.getValue().size();
		}
		return size;
	}

	/**
	 * 
	 * TODO description
	 * 
	 * @return {@code true} if {{@link #size1()} == 0}; {@code false} otherwise
	 */
	public boolean isEmpty() {
		return map.isEmpty();
	}

	public boolean containsKey1(T key) {
		return map.containsKey(key);
	}

	public boolean containsKey2(K key) {
		for (Map<K, V> v : map.values()) {
			if (v.keySet().contains(key))
				return true;
		}
		return false;
	}

	public boolean containsValue(V value) {
		for (Map<K, V> v : map.values()) {
			if (v.values().contains(value))
				return true;
		}
		return false;
	}

	public Map<K, V> get(T key1) {
		return map.get(key1);
	}

	public void put(T key1, K key2, V value) {
		MapUtils.addToMapMap(map, key1, key2, value, factory);
	}

	public Map<K, V> remove1(T key1) {
		return map.remove(key1);
	}

	public void remove2(K key2) {
		for (Map<K, V> c : map.values()) {
			c.remove(key2);
		}
	}

	public void clear() {
		map.clear();
	}

	public Set<T> keySet1() {
		return map.keySet();
	}

	public List<K> keyList2() {
		final List<K> result = new ArrayList<K>();
		for (Map<K, V> v : map.values()) {
			result.addAll(v.keySet());
		}
		return result;
	}

	/**
	 * 
	 * TODO description
	 * 
	 * @param key
	 *            Type of key1
	 * @return all values that are mapped by this key1
	 */
	public Collection<V> values(K key1) {
		return map.get(key1).values();
	}

	public Collection<V> values() {
		final Collection<V> result = new ArrayList<V>();
		for (Map<K, V> c : map.values()) {
			result.addAll(c.values());
		}
		return result;
	}

	public Set<Entry<T, Map<K, V>>> entrySet() {
		return map.entrySet();
	}

	public boolean equals(Object o) {
		return map.equals(o);
	}

	public int hashCode() {
		return map.hashCode();
	}

	@Override
	public String toString() {
		return map.toString();
	}

}

package net.sf.kerner.utils.collections.map.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import net.sf.kerner.utils.collections.map.MapFactory;
import net.sf.kerner.utils.collections.map.MapUtils;

public class MapMap<T, K, V> {

	private final Map<T, Map<K, V>> map;

	private final MapFactory<K, V> factory;

	public MapMap(Map<T, Map<K, V>> map, MapFactory<K, V> factory) {
		this.map = map;
		this.factory = factory;
	}
	
	public MapMap(Map<T, Map<K, V>> map) {
		this(map, new LinkedHashMapFactory<K, V>());
	}

	public int size() {
		return map.size();
	}

	public boolean isEmpty() {
		return map.isEmpty();
	}

	public boolean containsKey1(T key) {
		return map.containsKey(key);
	}
	
	public boolean containsKey2(K key) {
		for(Map<K, V> v : map.values()){
			if(v.keySet().contains(key))
				return true;
		}
		return false;
	}

	public boolean containsValue(V value) {
		for(Map<K, V> v : map.values()){
			if(v.values().contains(value))
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

	public Map<K,V> remove1(T key1) {
		return map.remove(key1);
	}
	
	public void remove2(K key2) {
		for(Map<K, V> c : map.values()){
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
		for(Map<K, V> v : map.values()){
			result.addAll(v.keySet());
		}
		return result;
	}

	public Collection<V> values(K key) {
		return map.get(key).values();
	}
	
	public Collection<V> values() {
		final Collection<V> result = new ArrayList<V>();
		for(Map<K, V> c : map.values()){
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

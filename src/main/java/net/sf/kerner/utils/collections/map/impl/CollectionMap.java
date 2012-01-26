package net.sf.kerner.utils.collections.map.impl;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import net.sf.kerner.utils.collections.CollectionFactory;
import net.sf.kerner.utils.collections.list.impl.ArrayListFactory;
import net.sf.kerner.utils.collections.map.MapFactory;
import net.sf.kerner.utils.collections.map.MapUtils;

public class CollectionMap<K, V> {
	
	private final Map<K, Collection<V>> map;
	
	private final CollectionFactory<V> collectionFactory;
	
	public CollectionMap(MapFactory<K, Collection<V>> mapFactory, CollectionFactory<V> collectionFactory){
		this.map = mapFactory.create();
		this.collectionFactory = collectionFactory;
	}
	
	public CollectionMap(){
		this(new LinkedHashMapFactory<K, Collection<V>>(), new ArrayListFactory<V>());
	}

	public int size() {
		return map.size();
	}

	public boolean isEmpty() {
		return map.isEmpty();
	}

	public boolean containsKey(Object key) {
		return map.containsKey(key);
	}

	public boolean containsValue(Object value) {
		for(Collection<V> v : map.values()){
			if(v.contains(value))
				return true;
		}
		return false;
	}

	public Collection<V> get(Object key) {
		return map.get(key);
	}

	public void put(K key, V value) {
		MapUtils.addToCollectionsMap(map, key, value, collectionFactory);
	}

	public boolean remove(Object key) {
		boolean result = false;
		for(Collection<V> c : map.values()){
			boolean b = c.remove(key);
			if(b)
				result = b;
		}
		return result;
	}

	public void putAll(Map<? extends K, ? extends V> m) {
		for(java.util.Map.Entry<? extends K, ? extends V> e : m.entrySet()){
			this.put(e.getKey(), e.getValue());
		}
	}

	public void clear() {
		map.clear();
	}

	public Set<K> keySet() {
		return map.keySet();
	}

	public Collection<V> values() {
		final Collection<V> result = collectionFactory.createCollection();
		for(Collection<V> c : map.values()){
			result.addAll(c);
		}
		return result;
	}

	public Set<java.util.Map.Entry<K, Collection<V>>> entrySet() {
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

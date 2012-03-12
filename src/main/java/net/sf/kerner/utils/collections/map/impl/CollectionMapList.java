package net.sf.kerner.utils.collections.map.impl;

import java.util.List;

import net.sf.kerner.utils.collections.list.ListFactory;
import net.sf.kerner.utils.collections.list.impl.ArrayListFactory;
import net.sf.kerner.utils.collections.map.MapFactory;

public class CollectionMapList<K, V> extends CollectionMapAbstract<K, V, List<V>> {
	
	private final ListFactory<V> factory;

	public CollectionMapList() {
		this.factory = new ArrayListFactory<V>();
	}

	public CollectionMapList(MapFactory<K, List<V>> mapFactory, ListFactory<V> factory) {
		super(mapFactory);
		this.factory = factory;
	}

	public List<V> get(K key) {
		return map.get(key);
	}
	
	public void put(K key, V value) {
		
		// TODO see {@link MapUtils#addToCollectionsMap()}
		
		List<V> col = map.get(key);
		if (col == null) {
			col = factory.createCollection();
			map.put(key, col);
		}
		col.add(value);
	}

	public List<V> values() {
		final List<V> result = factory.createCollection();
		for (List<V> c : map.values()) {
			result.addAll(c);
		}
		return result;
	}

}

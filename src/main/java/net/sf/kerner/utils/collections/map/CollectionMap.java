package net.sf.kerner.utils.collections.map;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public interface CollectionMap<K, V, L extends Collection<V>> {

	void put(K k, V v);
	
	void putAll(K k, Collection<? extends V> elements);
	
	void putAll(Map<? extends K, ? extends V> m);
	
	int size();
	
	int size(K k);
	
	boolean isEmpty();
	
	boolean isEmpty(K k);
	
	boolean containsKey(K k);
	
	boolean containsValue(V v);
	
	L get(K k);
	
	void remove(K k);
	
	void clear();
	
	Set<K> keySet();
	
	L values();

	Set<Entry<K, L>> entrySet();
}

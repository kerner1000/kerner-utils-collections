package net.sf.kerner.utils.collections.map.impl;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import net.sf.kerner.utils.Factory;

public class AutoCreateValueMapDecorator<K, V> implements Map<K, V> {

	private final Map<K, V> decorated;

	private final Factory<V> factory;

	public AutoCreateValueMapDecorator(Map<K, V> decorated, Factory<V> factory) {
		super();
		this.decorated = decorated;
		this.factory = factory;
	}

	@SuppressWarnings("unchecked")
	public V get(Object key) {
		if (decorated.containsKey(key)) {
			// ok
		} else {
			// System.err.println("dont know this key [" + key + "]");
			decorated.put((K) key, factory.create());
		}
		return decorated.get(key);
	}

	// Delegate //

	@Override
	public String toString() {
		return decorated.toString();
	}

	public int size() {
		return decorated.size();
	}

	public boolean isEmpty() {
		return decorated.isEmpty();
	}

	public boolean containsKey(Object key) {
		return decorated.containsKey(key);
	}

	public boolean containsValue(Object value) {
		return decorated.containsValue(value);
	}

	public V put(K key, V value) {
		return decorated.put(key, value);
	}

	public V remove(Object key) {
		return decorated.remove(key);
	}

	public void putAll(Map<? extends K, ? extends V> m) {
		decorated.putAll(m);
	}

	public void clear() {
		decorated.clear();
	}

	public Set<K> keySet() {
		return decorated.keySet();
	}

	public Collection<V> values() {
		return decorated.values();
	}

	public Set<java.util.Map.Entry<K, V>> entrySet() {
		return decorated.entrySet();
	}

	public boolean equals(Object o) {
		return decorated.equals(o);
	}

	public int hashCode() {
		return decorated.hashCode();
	}

}

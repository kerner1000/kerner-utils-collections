package net.sf.kerner.utils.collections.impl;

import java.util.List;

import net.sf.kerner.utils.KeyValue;
import net.sf.kerner.utils.KeyValueViewValue;
import net.sf.kerner.utils.collections.list.ListFactory;
import net.sf.kerner.utils.collections.list.ListTransformer;
import net.sf.kerner.utils.collections.list.impl.ArrayListFactory;

public class KeyValueViewValues<K, V> extends KeyValueViewValue<K, V> implements
ListTransformer<KeyValue<K, V>, V> {

	private final ListFactory<V> factory;

	public KeyValueViewValues(ListFactory<V> factory) {
		this.factory = factory;
	}

	public KeyValueViewValues() {
		this(new ArrayListFactory<V>());
	}

	public List<V> transformList(List<? extends KeyValue<K, V>> element) {
		List<V> result = factory.createCollection();
		for (KeyValue<K, V> e : element) {
			result.add(transform(e));
		}
		return result;
	}

}

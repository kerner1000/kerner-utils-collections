package net.sf.kerner.utils.collections.impl;

import java.util.List;

import net.sf.kerner.utils.KeyValue;
import net.sf.kerner.utils.KeyValueViewKey;
import net.sf.kerner.utils.collections.list.ListFactory;
import net.sf.kerner.utils.collections.list.ListTransformer;
import net.sf.kerner.utils.collections.list.impl.ArrayListFactory;

public class KeyValueViewKeys<K> extends KeyValueViewKey<K> implements
		ListTransformer<KeyValue<K, ?>, K> {

	private final ListFactory<K> factory;

	public KeyValueViewKeys(ListFactory<K> factory) {
		this.factory = factory;
	}

	public KeyValueViewKeys() {
		this(new ArrayListFactory<K>());
	}

	public List<K> transformList(List<? extends KeyValue<K, ?>> element) {
		List<K> result = factory.createCollection();
		for (KeyValue<K, ?> e : element) {
			result.add(transform(e));
		}
		return result;
	}

}

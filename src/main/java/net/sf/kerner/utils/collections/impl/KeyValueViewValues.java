package net.sf.kerner.utils.collections.impl;

import java.util.List;

import net.sf.kerner.utils.KeyValue;
import net.sf.kerner.utils.KeyValueViewValue;
import net.sf.kerner.utils.collections.list.ListFactory;
import net.sf.kerner.utils.collections.list.ListTransformer;
import net.sf.kerner.utils.collections.list.impl.ArrayListFactory;

public class KeyValueViewValues<V> extends KeyValueViewValue<V> implements
ListTransformer<KeyValue<?, V>, V> {

	private final ListFactory<V> factory;

	public KeyValueViewValues(ListFactory<V> factory) {
		this.factory = factory;
	}

	public KeyValueViewValues() {
		this(new ArrayListFactory<V>());
	}

	public List<V> transformList(List<? extends KeyValue<?, V>> element) {
		List<V> result = factory.createCollection();
		for (KeyValue<?, V> e : element) {
			result.add(transform(e));
		}
		return result;
	}

}

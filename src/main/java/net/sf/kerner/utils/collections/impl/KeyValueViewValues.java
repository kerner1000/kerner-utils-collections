package net.sf.kerner.utils.collections.impl;

import java.util.Collection;
import java.util.List;

import net.sf.kerner.utils.KeyValue;
import net.sf.kerner.utils.ViewKeyValueValue;
import net.sf.kerner.utils.collections.TransformerCollection;
import net.sf.kerner.utils.collections.list.ListFactory;
import net.sf.kerner.utils.collections.list.TransformerList;
import net.sf.kerner.utils.collections.list.impl.ArrayListFactory;

public class KeyValueViewValues<V> extends ViewKeyValueValue<V> implements
TransformerCollection<KeyValue<?, V>, V> {

	private final ListFactory<V> factory;

	public KeyValueViewValues(ListFactory<V> factory) {
		this.factory = factory;
	}

	public KeyValueViewValues() {
		this(new ArrayListFactory<V>());
	}

	public List<V> transformCollection(Collection<? extends KeyValue<?, V>> element) {
		List<V> result = factory.createCollection();
		for (KeyValue<?, V> e : element) {
			result.add(transform(e));
		}
		return result;
	}

}
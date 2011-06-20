package net.sf.kerner.utils.collections.list;

import java.util.List;

import net.sf.kerner.utils.collections.list.impl.ArrayListFactory;
import net.sf.kerner.utils.transformer.Transformer;

public abstract class AbstractListTransformer<T, V> implements Transformer<T, V>,
		ListTransformer<T, V> {

	private final ListFactory<V> factory;

	public AbstractListTransformer(ListFactory<V> factory) {
		super();
		this.factory = factory;
	}
	
	public AbstractListTransformer() {
		this(new ArrayListFactory<V>());
	}

	public synchronized List<V> transformList(List<? extends T> element) {
		final List<V> result = factory.createCollection();
		if(element != null)
		for (T t : element) {
			result.add(transform(t));
		}
		return result;
	}

}

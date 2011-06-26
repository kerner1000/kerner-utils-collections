package net.sf.kerner.utils.collections.list;

import java.util.Collection;
import java.util.List;

public abstract class AbstractTransformingListFactory<T, V> extends AbstractListTransformer<T, V> implements ListFactory<V> {

	public AbstractTransformingListFactory() {
		super();
	}

	public AbstractTransformingListFactory(ListFactory<V> factory) {
		super(factory);
	}
	
	public List<V> createCollection() {
		return factory.createCollection();
	}
	
	public List<V> createCollection(Collection<? extends V> template) {
		return factory.createCollection(template);
	}

}

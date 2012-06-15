package net.sf.kerner.utils.collections.list.impl;

import java.util.Collection;
import java.util.List;

import net.sf.kerner.utils.collections.list.FactoryList;

public abstract class AbstractTransformingListFactory<T, V> extends AbstractListTransformer<T, V> implements
        FactoryList<V> {

    public AbstractTransformingListFactory() {
        super();
    }

    public AbstractTransformingListFactory(FactoryList<V> factory) {
        super(factory);
    }

    public List<V> createCollection() {
        return factory.createCollection();
    }

    public List<V> createCollection(Collection<? extends V> template) {
        return factory.createCollection(template);
    }

}

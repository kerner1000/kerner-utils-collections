package net.sf.kerner.utils.collections.impl;

import java.util.Collection;

import net.sf.kerner.utils.Transformer;
import net.sf.kerner.utils.collections.FactoryCollection;
import net.sf.kerner.utils.collections.TransformerCollection;

public abstract class TransformerAbstract<T, V> implements Transformer<T, V>, TransformerCollection<T, V> {

    protected final FactoryCollection<V> factoryCollection;

    public TransformerAbstract(final FactoryCollection<V> factoryCollection) {
        super();
        this.factoryCollection = factoryCollection;
    }

    public Collection<V> transformCollection(final Collection<? extends T> element) {
        final Collection<V> result = factoryCollection.createCollection();
        for (final T t : element) {
            result.add(transform(t));
        }
        return result;
    }
}

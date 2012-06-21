package net.sf.kerner.utils.collections.set.impl;

import java.util.Collection;
import java.util.Set;

import net.sf.kerner.utils.collections.TransformerCollection;

public interface TransformerSet<T, V> extends TransformerCollection<T, V> {

    /**
     * Transforms each element contained by given {@link Set} and returns another {@link Set} which contains all
     * transformed elements (in the same order).
     * 
     * @param collection
     *            {@link Collection} that contains elements to transform
     * @return {@link Set} containing transformed elements
     */
    Set<V> transformCollection(Collection<? extends T> collection);

}

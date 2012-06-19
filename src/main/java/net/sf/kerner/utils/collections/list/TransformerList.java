package net.sf.kerner.utils.collections.list;

import java.util.List;

public interface TransformerList<T, V> {

    /**
     * Transforms each element contained by given {@link List} and returns another {@link List} which contains all
     * transformed elements (in the same order).
     * 
     * @param list
     *            {@link List} that contains elements to transform
     * @return {@link List} containing transformed elements
     */
    List<V> transformCollection(List<? extends T> list);

}

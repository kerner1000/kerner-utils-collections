package net.sf.kerner.utils.collections.list;

import java.util.List;

public interface TransformerList<T, V> {

    List<V> transformCollection(List<? extends T> element);

}

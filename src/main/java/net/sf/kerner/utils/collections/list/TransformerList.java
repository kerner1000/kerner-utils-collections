package net.sf.kerner.utils.collections.list;

import java.util.Collection;
import java.util.List;

import net.sf.kerner.utils.collections.TransformerCollection;

public interface TransformerList<T, V> extends TransformerCollection<T, V> {

    List<V> transformCollection(Collection<? extends T> element);

}

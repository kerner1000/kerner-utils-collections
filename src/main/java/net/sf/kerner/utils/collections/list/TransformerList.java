package net.sf.kerner.utils.collections.list;

import java.util.Collection;
import java.util.List;

import net.sf.kerner.utils.collections.TransformerCollection;

public interface TransformerList<T, V> {

	List<V> transformCollection(List<? extends T> element);

}

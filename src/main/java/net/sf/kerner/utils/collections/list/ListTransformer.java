package net.sf.kerner.utils.collections.list;

import java.util.List;

public interface ListTransformer<T, V> {
	
	List<V> transformList(List<? extends T> element);

}

package net.sf.kerner.utils.collections.list;

import java.util.Collection;
import java.util.List;

public interface TransformingListFactory<S, E> {
	
	List<E> createCollection(Collection<? extends S> elements);

}

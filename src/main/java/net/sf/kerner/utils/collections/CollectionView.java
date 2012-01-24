package net.sf.kerner.utils.collections;

import java.util.Collection;

public interface CollectionView<T> extends Collection<T> {
	
	CollectionView<T> getView(Filter<T> filter);

}

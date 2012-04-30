package net.sf.kerner.utils.collections.list;

import java.util.List;

import net.sf.kerner.utils.collections.Selector;

public interface SelectorList<T> extends Selector<T> {

	T select(List<? extends T> elements);

	int getIndex();

}

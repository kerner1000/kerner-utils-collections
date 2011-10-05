package net.sf.kerner.utils.collections.list;

import java.util.List;
import java.util.ListIterator;

public interface ListWalker<E> {
	
	void walk(List<? extends E> list);
	
	ListIterator<? extends E> getIterator();

}

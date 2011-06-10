package net.sf.kerner.utils.collections.list;

import java.util.List;

public interface ListWalker<E> {
	
	void walk(List<? extends E> list);

}

package net.sf.kerner.utils.collections.list;

import java.util.List;

import net.sf.kerner.utils.collections.Filter;

public interface ListWalker<E> {
	
	void beforeWalk();
	
	void walk(List<? extends E> list);
	
	void afterWalk();
	
	void addFilter(Filter<E> filter);
	
	void clearFilters();
	
	void addVisitor(DefaultListVisitor<E> visitor);
	
	void clearVisitors();

}

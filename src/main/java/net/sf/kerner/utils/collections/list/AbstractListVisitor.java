package net.sf.kerner.utils.collections.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import net.sf.kerner.utils.collections.DefaultVisitor;
import net.sf.kerner.utils.collections.Filter;

public abstract class AbstractListVisitor<E> implements ListWalker<E>, DefaultVisitor<E> {
	
	protected final Collection<Filter<E>> filters = new ArrayList<Filter<E>>();
	
	public synchronized void addFilter(Filter<E> filter){
		filters.add(filter);
	}
	
	public synchronized void clearFilters(){
		filters.clear();
	}
	
	public void beforeWalk(){
		
	}
	
	public synchronized void walk(List<? extends E> list) {
		beforeWalk();
		for(E e : list){
			boolean take = true;
			for(Filter<E> f : filters){
				if(f.visit(e)){
					// take
				} else {
					take = false;
					break;
				}
			}
			if(take)
			visit(e);
		}
		afterWalk();
	}
	
	public void afterWalk(){
		
	}

}

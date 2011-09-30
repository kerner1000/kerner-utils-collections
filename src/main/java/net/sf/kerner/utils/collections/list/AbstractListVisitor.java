package net.sf.kerner.utils.collections.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import net.sf.kerner.utils.collections.Filter;
import net.sf.kerner.utils.collections.Visitor;

public abstract class AbstractListVisitor<V, E> implements ListWalker<E>, Visitor<V, E> {
	
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
			handleVisit(visit(e));
		}
		afterWalk();
	}
	
	public void afterWalk(){
		
	}
	
	protected abstract void handleVisit(V v);

}

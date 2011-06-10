package net.sf.kerner.utils.collections.list;

import java.util.List;

public abstract class AbstractDefaultVisitingListWalker<E> implements DefaultVisitingListWalker<E> {

	public void beforeWalk(){
		
	};
	
	public void walk(List<? extends E> list) {
		beforeWalk();
		for(E e : list){
			visit(e);
		}
		afterWalk();
	}
	
	public void afterWalk(){
		
	}

}

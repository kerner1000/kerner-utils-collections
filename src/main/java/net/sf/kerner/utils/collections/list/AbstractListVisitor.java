package net.sf.kerner.utils.collections.list;

import java.util.List;

import net.sf.kerner.utils.collections.DefaultVisitor;

public abstract class AbstractListVisitor<E> implements ListWalker<E>, DefaultVisitor<E> {
	
	public void beforeWalk(){
		
	}
	
	public synchronized void walk(List<? extends E> list) {
		beforeWalk();
		for(E e : list){
			visit(e);
		}
		afterWalk();
	}
	
	public void afterWalk(){
		
	}

}

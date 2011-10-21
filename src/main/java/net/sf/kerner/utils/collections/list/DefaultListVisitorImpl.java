package net.sf.kerner.utils.collections.list;

import java.util.ListIterator;

public class DefaultListVisitorImpl<E> implements DefaultListVisitor<E>{
	
	public Void visit(E e) {
		// do nothing by default
		return null;
	}

	public Void visit(E e, ListIterator<? extends E> iterator) {
		// do nothing by default
		return null;
	}

}

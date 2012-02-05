package net.sf.kerner.utils.collections.list.impl;

import net.sf.kerner.utils.collections.list.DefaultListVisitor;

public class DefaultListVisitorImpl<E> implements DefaultListVisitor<E> {

	public Void visit(E e) {
		// do nothing by default
		return null;
	}

	public Void visit(E e, int index) {
		// do nothing by default
		return null;
	}

}

package net.sf.kerner.utils.collections.list;

import java.util.ListIterator;

import net.sf.kerner.utils.collections.Visitor;

public interface ListVisitor<V, E> extends Visitor<V, E> {
	
	ListIterator<? extends E> getIterator();

}

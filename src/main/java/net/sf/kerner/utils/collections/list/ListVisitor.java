package net.sf.kerner.utils.collections.list;

import java.util.ListIterator;

import net.sf.kerner.utils.collections.Visitor;

public interface ListVisitor<R, E> extends Visitor<R, E>{
	
	R visit(E e);
	
	R visit(E e, ListIterator<? extends E> iterator);

}

package net.sf.kerner.utils.collections;

public interface Visitor<R, E> {

	R visit(E element);
	
}

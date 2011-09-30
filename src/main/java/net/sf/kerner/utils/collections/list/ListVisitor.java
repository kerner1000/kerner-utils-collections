package net.sf.kerner.utils.collections.list;

import net.sf.kerner.utils.collections.Visitor;

public interface ListVisitor<V, E> extends Visitor<V, E> {
	
	int getIndex();

}

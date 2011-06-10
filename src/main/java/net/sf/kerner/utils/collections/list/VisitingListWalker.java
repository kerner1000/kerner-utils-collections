package net.sf.kerner.utils.collections.list;

import net.sf.kerner.utils.collections.Visitor;

public interface VisitingListWalker<R, E> extends ListWalker<E>, Visitor<R, E>{

}

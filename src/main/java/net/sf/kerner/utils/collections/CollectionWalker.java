package net.sf.kerner.utils.collections;

import java.util.Collection;

import net.sf.kerner.utils.collections.filter.FilterApplier;
import net.sf.kerner.utils.collections.visitor.VisitorApplierDefault;

public interface CollectionWalker<E> extends Walker<E>, FilterApplier<E>, VisitorApplierDefault<E> {

    void walk(Collection<? extends E> list);

}

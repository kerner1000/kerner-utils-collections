package net.sf.kerner.utils.collections.list;

import java.util.List;

import net.sf.kerner.utils.collections.Walker;
import net.sf.kerner.utils.collections.filter.FilterApplier;
import net.sf.kerner.utils.collections.list.visitor.VisitorApplierListDefault;

public interface ListWalker<E> extends Walker<E>, FilterApplier<E>, VisitorApplierListDefault<E> {

    void walk(List<? extends E> list);

}

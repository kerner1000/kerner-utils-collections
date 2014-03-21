package net.sf.kerner.utils.collections.list.impl;

import java.util.List;
import java.util.ListIterator;

import net.sf.kerner.utils.collections.list.ListWalker;
import net.sf.kerner.utils.collections.list.impl.filter.FilterVisitorListApplierProto;

public class ListWalkerDefault<E> extends FilterVisitorListApplierProto<E> implements ListWalker<E> {

    public void afterWalk() {
        // do nothing by default
    }

    public void beforeWalk() {
        // do nothing by default
    }

    public void walk(final List<? extends E> list) {
        synchronized (list) {
            beforeWalk();
            for (final ListIterator<? extends E> it = list.listIterator(); it.hasNext();) {
                final int index = it.nextIndex();
                final E e = it.next();
                visit(e, index);
            }
            afterWalk();
        }
    }
}

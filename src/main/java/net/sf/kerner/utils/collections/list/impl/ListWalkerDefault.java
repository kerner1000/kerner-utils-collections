package net.sf.kerner.utils.collections.list.impl;

import java.util.List;

import net.sf.kerner.utils.collections.list.ListWalker;
import net.sf.kerner.utils.collections.list.impl.filter.FilterVisitorListApplierProto;

public class ListWalkerDefault<E> extends FilterVisitorListApplierProto<E> implements ListWalker<E> {

    public synchronized void walk(final List<? extends E> list) {
        beforeWalk();
        for (int i = 0; i < list.size(); i++) {
            final E e = list.get(i);
            visit(e, i);
        }
        afterWalk();
    }

    public void beforeWalk() {
        // do nothing by default
    }

    public void afterWalk() {
        // do nothing by default
    }
}

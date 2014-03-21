package net.sf.kerner.utils.collections;

import java.util.Collection;

import net.sf.kerner.utils.collections.filter.impl.FilterVisitorApplierProto;

public class CollectionWalkerImpl<E> extends FilterVisitorApplierProto<E> implements CollectionWalker<E> {

    public void walk(final Collection<? extends E> list) {
        beforeWalk();
        for (final E e : list) {
            if (filter(e)) {
                visit(e);
            }
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

package net.sf.kerner.utils.collections.list.impl;

import net.sf.kerner.utils.collections.list.visitor.VisitorListDefault;

public class DefaultListVisitorImpl<E> implements VisitorListDefault<E> {

    public Void visit(final E e, final int index) {
        // do nothing by default
        return null;
    }

}

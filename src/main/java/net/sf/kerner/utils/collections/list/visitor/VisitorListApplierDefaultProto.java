package net.sf.kerner.utils.collections.list.visitor;

import java.util.Collection;

import net.sf.kerner.utils.collections.UtilCollection;

public class VisitorListApplierDefaultProto<E> implements VisitorApplierListDefault<E> {

    protected final Collection<VisitorList<Void, E>> visitors = UtilCollection.newCollection();

    public synchronized void addVisitor(final VisitorList<Void, E> visitor) {
        visitors.add(visitor);
    }

    public synchronized void clearVisitors() {
        visitors.clear();
    }

    public void visit(final E e, final int index) {

        for (final VisitorList<Void, E> v : visitors) {
            v.visit(e, index);
        }

    };

}

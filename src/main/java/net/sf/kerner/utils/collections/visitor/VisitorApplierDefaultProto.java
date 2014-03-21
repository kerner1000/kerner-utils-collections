package net.sf.kerner.utils.collections.visitor;

import java.util.Collection;

import net.sf.kerner.utils.collections.UtilCollection;

public class VisitorApplierDefaultProto<E> implements VisitorApplierDefault<E> {

    protected final Collection<Visitor<Void, E>> visitors = UtilCollection.newCollection();

    public synchronized void addVisitor(final Visitor<Void, E> visitor) {
        visitors.add(visitor);
    }

    public synchronized void clearVisitors() {
        visitors.clear();
    }

    public Void visit(final E e) {

        for (final Visitor<Void, E> v : visitors) {
            v.visit(e);
        }
        return null;

    };

}

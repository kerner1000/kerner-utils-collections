package net.sf.kerner.utils.collections.impl.filter;

import java.util.List;

import net.sf.kerner.utils.collections.filter.Filter;
import net.sf.kerner.utils.collections.filter.FilterApplier;
import net.sf.kerner.utils.collections.impl.visitor.VisitorApplierDefaultProto;
import net.sf.kerner.utils.collections.visitor.Visitor;
import net.sf.kerner.utils.collections.visitor.VisitorApplierDefault;

public class FilterVisitorApplierProto<E> implements FilterApplier<E>, VisitorApplierDefault<E> {

    private final FilterApplier<E> filterDelegate = new FilterApplierProto<E>();

    private final VisitorApplierDefault<E> visitorDelegate = new VisitorApplierDefaultProto<E>();

    public void addFilter(final Filter<E> filter) {
        filterDelegate.addFilter(filter);
    }

    public void addVisitor(final Visitor<Void, E> visitor) {
        visitorDelegate.addVisitor(visitor);
    }

    public void clearFilters() {
        filterDelegate.clearFilters();
    }

    public void clearVisitors() {
        visitorDelegate.clearVisitors();
    }

    public boolean filter(final E e) {
        final boolean b = filterDelegate.filter(e);
        if (b) {
            visitorDelegate.visit(e);
        }
        return b;
    }

    public List<Filter<E>> getFilters() {
        return filterDelegate.getFilters();
    }

    public Void visit(final E e) {
        if (filter(e)) {
            visitorDelegate.visit(e);
        }
        return null;
    }
}

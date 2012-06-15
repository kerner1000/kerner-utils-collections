package net.sf.kerner.utils.collections.list.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import net.sf.kerner.utils.collections.Filter;
import net.sf.kerner.utils.collections.list.ListWalker;
import net.sf.kerner.utils.collections.list.VisitorListDefault;

public class ListWalkerDefault<E> implements ListWalker<E> {

    protected final Collection<Filter<E>> filters = new ArrayList<Filter<E>>();

    protected final Collection<VisitorListDefault<E>> visitors = new ArrayList<VisitorListDefault<E>>();

    public synchronized void addFilter(Filter<E> filter) {
        filters.add(filter);
    }

    public synchronized void clearFilters() {
        filters.clear();
    }

    public synchronized void addVisitor(VisitorListDefault<E> visitor) {
        visitors.add(visitor);
    }

    public synchronized void clearVisitors() {
        visitors.clear();
    }

    public void beforeWalk() {

    }

    public synchronized void walk(List<? extends E> list) {
        beforeWalk();
        for (int i = 0; i < list.size(); i++) {
            final E e = list.get(i);
            boolean take = true;
            for (Filter<E> f : filters) {
                if (f.visit(e)) {
                    // take
                } else {
                    take = false;
                    break;
                }
            }
            if (take) {
                for (VisitorListDefault<E> v : visitors) {
                    v.visit(e, i);
                    v.visit(e);
                }
            }
            afterWalk();
        }
    }

    public void afterWalk() {

    }
}

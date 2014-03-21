package net.sf.kerner.utils.collections.filter.impl;

import java.util.ArrayList;
import java.util.List;

import net.sf.kerner.utils.collections.applier.Applier;
import net.sf.kerner.utils.collections.applier.ApplierAbstract;
import net.sf.kerner.utils.collections.filter.Filter;
import net.sf.kerner.utils.collections.filter.FilterApplier;
import net.sf.kerner.utils.collections.list.impl.UtilList;

public class FilterApplierProto<E> extends ApplierAbstract implements FilterApplier<E> {

    private List<Filter<E>> filters = UtilList.newList();

    public FilterApplierProto() {
        this(DEFAULT_FILTER_TYPE);
    }

    public FilterApplierProto(final Filter<E>... filters) {
        this(DEFAULT_FILTER_TYPE, filters);
    }

    public FilterApplierProto(final TYPE type) {
        super(type);
    }

    public FilterApplierProto(final TYPE type, final Filter<E>... filters) {
        super(type);
        for (final Filter<E> f : filters) {
            this.filters.add(f);
        }
    }

    public synchronized FilterApplierProto<E> addFilter(final Filter<E> filter) {
        filters.add(filter);
        return this;
    }

    public synchronized void clear() {
        filters.clear();
    }

    public synchronized boolean filter(final E e) {
        switch (type) {
            case ALL:
                for (final Filter<E> f : filters) {
                    if (f.filter(e)) {
                        // take
                    } else {
                        return false;
                    }
                }
                return true;
            case ONE:
                for (final Filter<E> f : filters) {
                    if (f.filter(e)) {
                        return true;
                    } else {

                    }
                }
                return false;
            default:
                throw new RuntimeException("unknown type " + type);
        }
    }

    public synchronized List<Filter<E>> getFilters() {
        return new ArrayList<Filter<E>>(filters);
    }

    public synchronized boolean isEmpty() {
        return this.filters.isEmpty();
    }

    public synchronized void setFilters(final List<Filter<E>> filters) {
        this.filters = new ArrayList<Filter<E>>(filters);
    }

    public synchronized void setFilterType(final Applier.TYPE filterType) {
        super.type = filterType;
    }

    @Override
    public String toString() {
        return getFilters().toString();
    }
}

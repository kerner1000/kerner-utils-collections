package net.sf.kerner.utils.collections.impl.filter;

import java.util.ArrayList;
import java.util.List;

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

    public synchronized void addFilter(final Filter<E> filter) {
        filters.add(filter);
    }

    public synchronized void clear() {
        filters.clear();
    }

    public boolean filter(final E e) {
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
                        // see what others say
                    }
                }
                return false;
            default:
                throw new RuntimeException("unknown type " + type);
        }
    }

    public List<Filter<E>> getFilters() {
        return new ArrayList<Filter<E>>(filters);
    }

    public void setFilters(final List<Filter<E>> filters) {
        this.filters = new ArrayList<Filter<E>>(filters);
    }

    @Override
    public String toString() {
        return getFilters().toString();
    }
}

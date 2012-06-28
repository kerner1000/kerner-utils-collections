package net.sf.kerner.utils.collections.impl.filter;

import java.util.Collection;

import net.sf.kerner.utils.collections.filter.Filter;
import net.sf.kerner.utils.collections.filter.FilterApplier;
import net.sf.kerner.utils.collections.impl.UtilCollection;

public class FilterApplierProto<E> implements FilterApplier<E> {

    public static TYPE DEFAULT_FILTER_TYPE = TYPE.ALL;

    protected final Collection<Filter<E>> filters = UtilCollection.newCollection();

    private final TYPE type;

    public FilterApplierProto(final TYPE type) {
        this.type = type;
    }

    public FilterApplierProto() {
        this(DEFAULT_FILTER_TYPE);
    }

    public FilterApplierProto(final TYPE type, final Filter<E>... filters) {
        for (final Filter<E> f : filters) {
            this.filters.add(f);
        }
        this.type = type;
    }

    public FilterApplierProto(final Filter<E>... filters) {
        this(DEFAULT_FILTER_TYPE, filters);
    }

    public synchronized void addFilter(final Filter<E> filter) {
        filters.add(filter);
    }

    public synchronized void clearFilters() {
        filters.clear();
    }

    public boolean filter(final E e) {
        switch (type) {
        case ALL:
            for (final Filter<E> f : filters) {
                if (f.visit(e)) {
                    // take
                } else {
                    return false;
                }
            }
            return true;
        case ONE:
            for (final Filter<E> f : filters) {
                if (f.visit(e)) {
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
}

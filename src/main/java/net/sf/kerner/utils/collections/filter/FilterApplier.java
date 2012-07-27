package net.sf.kerner.utils.collections.filter;

import java.util.List;

public interface FilterApplier<E> extends Filter<E> {

    static enum TYPE {
        ALL, ONE;
    }

    void addFilter(Filter<E> filter);

    void clearFilters();

    List<Filter<E>> getFilters();

}

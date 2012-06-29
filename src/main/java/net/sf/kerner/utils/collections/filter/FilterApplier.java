package net.sf.kerner.utils.collections.filter;

public interface FilterApplier<E> extends Filter<E> {

    static enum TYPE {
        ALL, ONE;
    }

    void addFilter(Filter<E> filter);

    void clearFilters();

}

package net.sf.kerner.utils.collections.filter;

import java.util.List;

import net.sf.kerner.utils.collections.applier.Applier;

public interface FilterApplier<E> extends Filter<E>, Applier {

    FilterApplier<E> addFilter(Filter<E> filter);

    List<Filter<E>> getFilters();

    boolean isEmpty();

}

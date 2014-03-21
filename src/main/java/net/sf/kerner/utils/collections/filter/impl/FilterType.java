package net.sf.kerner.utils.collections.filter.impl;

import net.sf.kerner.utils.collections.filter.Filter;

public class FilterType implements Filter<Object> {

    private final Class<?> clazz;

    public FilterType(final Class<?> clazz) {
        this.clazz = clazz;
    }

    public boolean filter(final Object e) {
        final boolean result = clazz.isInstance(e);
        return result;
    }
}

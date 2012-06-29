package net.sf.kerner.utils.collections.list.impl.filter;

import net.sf.kerner.utils.collections.list.filter.FilterList;

public class FilterNull<T> implements FilterList<T> {

    public boolean filter(final T element) {
        return element != null;
    }

    public boolean filter(final T element, final int index) {
        return element != null;
    }

}

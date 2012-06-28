package net.sf.kerner.utils.collections.list.impl.filter;

import net.sf.kerner.utils.collections.list.filter.FilterList;

public class FilterNull<T> implements FilterList<T> {

    public Boolean visit(T element) {
        return element != null;
    }

    public Boolean visit(T element, int index) {
        return element != null;
    }

}

package net.sf.kerner.utils.collections.impl.filter;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import net.sf.kerner.utils.collections.filter.Filter;

public class FilterGiven implements Filter<Object> {

    private final Set<Object> set;

    public FilterGiven(final Collection<Object> objects) {
        set = new HashSet<Object>(objects);
    }

    public boolean filter(final Object e) {
        return set.contains(e);
    }

}

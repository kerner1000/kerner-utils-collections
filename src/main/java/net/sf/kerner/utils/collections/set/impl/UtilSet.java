package net.sf.kerner.utils.collections.set.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

public class UtilSet {

    public static <T> T getFirstElement(final Set<T> set) {
        return set.iterator().next();
    }

    public static <T> T getLastElement(final Set<T> set) {
        return new ArrayList<T>(set).get(set.size() - 1);
    }

    public static boolean isNullSet(final Set<?> set) {
        if (set == null) {
            return true;
        }
        for (final Object o : set) {
            if (o != null) {
                return false;
            }
        }
        return true;
    }

    public static <T> Set<T> newSet() {
        return new LinkedHashSet<T>();
    }

    public static <T> Set<T> newSet(final Collection<? extends T> col) {
        return new LinkedHashSet<T>(col);
    }

}

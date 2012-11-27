package net.sf.kerner.utils.collections.impl.equalator;

import net.sf.kerner.utils.collections.Equalator;

public class EqualatorDefault<T> implements Equalator<T> {

    public boolean areEqual(final T o1, final T o2) {
        return o1.equals(o2);
    }

}

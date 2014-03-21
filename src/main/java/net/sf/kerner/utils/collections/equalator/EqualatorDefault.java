package net.sf.kerner.utils.collections.equalator;

import net.sf.kerner.utils.equal.EqualatorAbstract;

public class EqualatorDefault<T> extends EqualatorAbstract<T> {

    public boolean areEqual(final T o1, final Object o2) {
        return o1.equals(o2);
    }

}

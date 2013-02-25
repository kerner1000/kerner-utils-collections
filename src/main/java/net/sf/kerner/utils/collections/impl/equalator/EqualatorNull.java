package net.sf.kerner.utils.collections.impl.equalator;

import net.sf.kerner.utils.collections.Equalator;

public class EqualatorNull<T> implements Equalator<T> {

    private final Equalator<T> delegate;

    public EqualatorNull() {
        this(null);
    }

    public EqualatorNull(final Equalator<T> delegate) {
        super();
        if (delegate == null) {
            this.delegate = new EqualatorDefault<T>();
        } else {
            this.delegate = delegate;
        }
    }

    public boolean areEqual(final T o1, final T o2) {
        if (o1 == null && o2 == null) {
            return true;
        }
        if (o1 == null) {
            return false;
        }
        if (o2 == null) {
            return false;
        }

        return delegate.areEqual(o1, o2);

    }

}

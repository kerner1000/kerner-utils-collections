package net.sf.kerner.utils.collections;

import java.util.Collection;

public interface SelectorMulti<T> {

    Collection<T> select(Collection<? extends T> elements);

}

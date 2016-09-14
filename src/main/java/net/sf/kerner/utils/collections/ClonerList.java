package net.sf.kerner.utils.collections;

import java.util.Collection;
import java.util.List;

import net.sf.kerner.utils.Cloneable;

public interface ClonerList<T extends Cloneable<T>> {

    List<T> cloneList(Collection<? extends T> elements);

}

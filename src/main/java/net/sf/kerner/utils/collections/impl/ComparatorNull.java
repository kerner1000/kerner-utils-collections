package net.sf.kerner.utils.collections.impl;

import java.util.Comparator;

public abstract class ComparatorNull<T> implements Comparator<T>{

	public int compare(T o1, T o2) {
		if (o1 == null && o2 == null)
			return 0;
		if (o1 == null)
			return -1;
		if (o2 == null)
			return 1;
		return compareNonNull(o1, o2);
	}
	
	public abstract int compareNonNull(T o1, T o2);

}

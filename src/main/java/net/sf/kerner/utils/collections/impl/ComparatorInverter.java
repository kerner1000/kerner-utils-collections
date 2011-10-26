package net.sf.kerner.utils.collections.impl;

import java.util.Comparator;

public class ComparatorInverter<T> implements Comparator<T>{
	
	private final Comparator<T> c;
	
	public ComparatorInverter(Comparator<T> c) {
		this.c = c;
	}

	public int compare(T o1, T o2) {
		final int r = c.compare(o1, o2);
		if(r < 0)
			return 1;
		if(r > 0)
			return -1;
		return r;
	}

}

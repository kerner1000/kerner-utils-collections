package net.sf.kerner.utils.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import net.sf.kerner.utils.Cloneable;

public class ClonerCollection {

    public static <T extends Cloneable<T>> Collection<T> clone(final Collection<? extends T> list) {

	final List<T> result = new ArrayList<T>();
	for (final T t : list) {
	    result.add(t.clone());
	}
	return result;
    }
}

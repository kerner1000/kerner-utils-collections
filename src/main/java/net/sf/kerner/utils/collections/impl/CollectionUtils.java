package net.sf.kerner.utils.collections.impl;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

import net.sf.kerner.utils.StringUtils;
import net.sf.kerner.utils.collections.CollectionFactory;
import net.sf.kerner.utils.collections.list.impl.ArrayListFactory;

public class CollectionUtils {

	private CollectionUtils() {
	}

	/**
	 * 
	 * Create a new {@link Collection}, that contains all elements contained in
	 * first given collection and in second given collection. Ordering is as
	 * given by first {@code Collection}'s {@link Iterator} followed by second
	 * {@code Collection}'s {@link Iterator}.
	 * 
	 * @param <C> Type of {@link Collection}s
	 * @param c1 first {@link Collection}
	 * @param c2 second {@link Collection}
	 * @param factory {@link Factory} to create new {@code Collection}
	 * @return new {@code Collection}
	 */
	public static <C> Collection<C> append(Collection<? extends C> c1, Collection<? extends C> c2,
			CollectionFactory<C> factory) {
		final Collection<C> result = factory.createCollection(c1);
		result.addAll(c2);
		return result;
	}

	public static <C> Collection<C> append(Collection<? extends C> c1, Collection<? extends C> c2) {
		return append(c1, c2, new ArrayListFactory<C>());
	}

	/**
	 * 
	 * Simple {@code toString()} method, which calls each element's
	 * {@code toString()} and appends after that
	 * {@link StringUtils.NEW_LINE_STRING}.
	 * 
	 * @param elements
	 *            {@code Collection} of element's
	 * @return String representation for given {@code Collection}
	 */
	public static String toString(Iterable<?> elements) {
		if (!elements.iterator().hasNext())
			return "";
		final StringBuilder b = new StringBuilder();
		b.append(StringUtils.NEW_LINE_STRING);
		final Iterator<?> i = elements.iterator();
		while (i.hasNext()) {
			b.append(i.next());
			if (i.hasNext())
				b.append(StringUtils.NEW_LINE_STRING);
		}
		return b.toString();
	}

	public static <T> T getHighest(Collection<? extends T> elements, Comparator<T> c) {
		T result = null;

		for (T e : elements) {
			if (result == null) {
				result = e;
			} else {
				int i = c.compare(e, result);
				if (i > 0)
					result = e;
			}
		}

		return result;
	}

	public static <T> T getLowest(Collection<? extends T> elements, Comparator<T> c) {
		T result = null;

		for (T e : elements) {
			if (result == null) {
				result = e;
			} else {
				int i = c.compare(e, result);
				if (i < 0)
					result = e;
			}
		}

		return result;
	}

	/**
	 * 
	 * Check if a {@link Collection} or all of its elements is/ are {@code null}
	 * .
	 * 
	 * @param col
	 *            {@link Collection} to check
	 * @return true, if given {@link Collection} or all of its elements is/ are
	 *         {@code null}; {@code false} otherwise
	 */
	public static boolean nullCollection(Collection<?> col) {
		if (col == null)
			return true;
		for (Object o : col) {
			if (o != null)
				return false;
		}
		return true;
	}

}

/**********************************************************************
Copyright (c) 2009-2012 Alexander Kerner. All rights reserved.
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 ***********************************************************************/

package net.sf.kerner.utils.collections.impl;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;

import net.sf.kerner.utils.StringUtils;
import net.sf.kerner.utils.collections.FactoryCollection;
import net.sf.kerner.utils.collections.Filter;
import net.sf.kerner.utils.collections.ToStringStrategy;
import net.sf.kerner.utils.collections.list.ListVisitor;
import net.sf.kerner.utils.collections.list.impl.ArrayListFactory;
import net.sf.kerner.utils.factory.Factory;

/**
 * 
 * Utility class for Collection related stuff.
 * 
 * @author <a href="mailto:alex.kerner.24@googlemail.com">Alexander Kerner</a>
 * @version 2012-03-29
 * 
 */
public class CollectionUtils {

	public static String DEFAULT_OBJECT_SEPARATOR = ", ";

	public static ToStringStrategy<Object> DEFAULT_TO_STRING_STRATEGY = new ToStringStrategyDefault();

	private CollectionUtils() {
		// Singleton
	}

	/**
	 * 
	 * Create a new {@link Collection}, that contains all elements contained in
	 * first given collection and in second given collection. Ordering is as
	 * given by first {@code Collection Collection's} {@link Iterator} followed
	 * by second {@code Collection Collection's} {@link Iterator}.
	 * 
	 * @param <C>
	 *            Type of both {@link Collection Collections}
	 * @param c1
	 *            first {@link Collection}
	 * @param c2
	 *            second {@link Collection}
	 * @param factory
	 *            {@link Factory} to create new {@code Collection}
	 * @return new {@code Collection}
	 */
	public static <C> Collection<C> append(Collection<? extends C> c1, Collection<? extends C> c2,
			FactoryCollection<C> factory) {
		final Collection<C> result = factory.createCollection(c1);
		result.addAll(c2);
		return result;
	}

	/**
	 * 
	 * Same as {@link #append(c1, c2, new ArrayListFactory())}
	 * 
	 */
	public static <C> Collection<C> append(Collection<? extends C> c1, Collection<? extends C> c2) {
		return append(c1, c2, new ArrayListFactory<C>());
	}

	/**
	 * 
	 * Simple {@code toString()} method, which calls each element's
	 * {@code toString()} and appends after that
	 * {@link StringUtils.NEW_LINE_STRING}.
	 * 
	 * @return String representation for given {@code Collection}, or empty
	 *         string if parameter is empty
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

	/**
	 * 
	 * Retrieve highest element contained in a collection.
	 * 
	 * @param <T>
	 *            type of elements
	 * @param elements
	 *            collection of elements from which highest is returned
	 * @param c
	 *            {@link Comparator} to find highest
	 * @return highest element
	 */
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

	/**
	 * 
	 * Retrieve lowest element contained in a collection.
	 * 
	 * @param <T>
	 *            type of elements
	 * @param elements
	 *            collection of elements from which lowest is returned
	 * @param c
	 *            {@link Comparator} to find lowest
	 * @return lowest element
	 */
	public static <T> T getLowest(Collection<? extends T> elements, Comparator<T> c) {
		return getHighest(elements, new ComparatorInverter<T>(c));
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

	public static <O> String toString(Iterable<? extends O> iterable,
			ToStringStrategy<O> transformer, String objectSeparator) {
		final StringBuilder sb = new StringBuilder();
		final Iterator<? extends O> it = iterable.iterator();
		while (it.hasNext()) {
			sb.append(transformer.transform(it.next()));
			if (it.hasNext())
				sb.append(objectSeparator);
		}
		return sb.toString();
	}

	public static <O> String toString(ListIterator<? extends O> it, ListVisitor<String, O> visitor,
			String objectSeparator) {
		final StringBuilder sb = new StringBuilder();
		while (it.hasNext()) {
			final int index = it.nextIndex();
			sb.append(visitor.visit(it.next(), index));
			if (it.hasNext())
				sb.append(objectSeparator);
		}
		return sb.toString();
	}

	public static <O> String toString(Iterable<? extends O> it, ToStringStrategy<O> s) {
		return toString(it, s, DEFAULT_OBJECT_SEPARATOR);
	}

	public static <O> String toString(Iterable<? extends O> it, String objectSeparator) {
		return toString(it, DEFAULT_TO_STRING_STRATEGY, objectSeparator);
	}

	public static <O> String toString(ListIterator<? extends O> it, ListVisitor<String, O> s) {
		return toString(it, s, DEFAULT_OBJECT_SEPARATOR);
	}

	public static <C> Collection<C> filterCollection(Collection<? extends C> collection,
			Filter<C> filter, FactoryCollection<C> factory) {
		final Collection<C> result = factory.createCollection();
		for (C c : collection)
			if (filter.visit(c))
				result.add(c);
		return result;
	}

	public static <C> void filterCollection2(Collection<? extends C> collection, Filter<C> filter) {
		for (Iterator<? extends C> i = collection.iterator(); i.hasNext();) {
			if (filter.visit(i.next())) {
				// OK
			} else {
				i.remove();
			}
		}
	}

	public static <C> Collection<C> filterCollection(Collection<? extends C> collection,
			Filter<C> filter) {
		return filterCollection(collection, filter, new ArrayListFactory<C>());
	}

	public static int getNumberOfNonNullElements(Collection<?> col) {
		if (col == null)
			return 0;
		int result = 0;
		for (Object o : col) {
			if (o != null) {
				result++;
			}
		}
		return result;
	}

	public static int getNumberOfNonEmptyElements(Iterable<Collection<?>> col) {
		if (col == null)
			return 0;
		int result = 0;
		for (Collection<?> o : col) {
			if (o != null && !o.isEmpty()) {
				result++;
			}
		}
		return result;
	}

	public static boolean containsNull(Collection<?> c) {
		for (Object o : c) {
			if (o == null)
				return true;
		}
		return false;
	}

}

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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import net.sf.kerner.utils.Factory;
import net.sf.kerner.utils.Transformer;
import net.sf.kerner.utils.collections.Equalator;
import net.sf.kerner.utils.collections.FactoryCollection;
import net.sf.kerner.utils.collections.filter.Filter;
import net.sf.kerner.utils.collections.impl.equalator.EqualatorDefault;
import net.sf.kerner.utils.collections.list.impl.ArrayListFactory;
import net.sf.kerner.utils.collections.list.impl.UtilList;
import net.sf.kerner.utils.collections.list.visitor.VisitorList;
import net.sf.kerner.utils.impl.ObjectPairSameImpl;
import net.sf.kerner.utils.impl.TransformerToStringDefault;
import net.sf.kerner.utils.impl.util.Util;
import net.sf.kerner.utils.impl.util.UtilString;

/**
 * Utility class for Collection related stuff.
 * 
 * @author <a href="mailto:alexanderkerner24@gmail.com">Alexander Kerner</a>
 * @version 2012-11-27
 */
public class UtilCollection {

    public static String DEFAULT_OBJECT_SEPARATOR = ", ";

    public final static Transformer<Object, String> TRANSFORMER_TO_STRING_DEFAULT = new TransformerToStringDefault();

    /**
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
     * @return new {@code Collection}
     * @throws NullPointerException
     *             if one of arguments is {@code null}
     */
    public static <C> Collection<C> append(final Collection<? extends C> c1, final Collection<? extends C> c2) {
        return append(c1, c2, new ArrayListFactory<C>());
    }

    /**
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
     * @throws NullPointerException
     *             if one of arguments is {@code null}
     */
    public static <C> Collection<C> append(final Collection<? extends C> c1, final Collection<? extends C> c2,
            final FactoryCollection<C> factory) {
        Util.checkForNull(c1, c2, factory);
        final Collection<C> result = factory.createCollection(c1);
        result.addAll(c2);
        return result;
    }

    public static <T> boolean areAllEqual(final Collection<? extends T> elements) {
        return areAllEqual(elements, new EqualatorDefault<T>());
    }

    public static <T> boolean areAllEqual(final Collection<? extends T> elements, final Equalator<T> equalator) {
        final Collection<T> copy = new ArrayList<T>(elements);
        final Iterator<? extends T> it = copy.iterator();
        while (it.hasNext()) {
            final T t = it.next();
            it.remove();
            final Iterator<? extends T> it2 = copy.iterator();
            while (it2.hasNext()) {
                final T t2 = it2.next();
                it2.remove();
                if (equalator.areEqual(t, t2)) {
                    // ok
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Check whether {@code c1} contains any element in {@code c2}.
     * 
     * @param c1
     *            {@link Collection} to check for containing elements
     * @param c2
     *            elements which are checked if they are contained by {@code c1}
     * @return {@code true}, if any of {@code c2} is contained by {@code c1};
     *         {@code false} otherwise
     */
    public static boolean containsAny(final Collection<?> c1, final Object... c2) {
        for (final Object o : c2) {
            if (c1.contains(o)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks whether two or more elements in {@code c} have the same hashCode.
     * 
     * @see Object#hashCode()
     * @param c
     *            {@link Collection}
     * @return {@code true}, if {@code c} contains more than one element with
     *         same hashCode; {@code false} otherwise
     */
    public static boolean containsDuplicates(final Collection<?> c) {
        final Collection<Integer> hashes = UtilList.newList();
        for (final Object o : c) {
            final int hash = o.hashCode();
            if (hashes.contains(hash)) {
                return true;
            }
            hashes.add(hash);
        }
        return false;
    }

    /**
     * @throws NullPointerException
     *             if given argument is {@code null}
     */
    public static boolean containsNull(final Collection<?> c) {
        for (final Object o : c) {
            if (o == null)
                return true;
        }
        return false;
    }

    public static <C> void filterCollection(final Collection<? extends C> collection, final Filter<C> filter) {
        for (final Iterator<? extends C> i = collection.iterator(); i.hasNext();) {
            if (filter.filter(i.next())) {
                // OK
            } else {
                i.remove();
            }
        }
    }

    public static <T> Collection<T> findSame(final T key, final Collection<T> collection) {
        return findSame(key, collection, new EqualatorDefault<T>());
    }

    public static <T> Collection<T> findSame(final T key, final Collection<T> collection, final Equalator<T> equalator) {
        final Collection<T> result = newCollection();
        for (final T t : collection) {
            if (equalator.areEqual(key, t)) {
                result.add(t);
            }
        }
        return result;
    }

    public static <T> T findSameFirst(final T key, final Collection<T> collection) {
        return findSameFirst(key, collection, new EqualatorDefault<T>());
    }

    public static <T> T findSameFirst(final T key, final Collection<T> collection, final Equalator<T> equalator) {
        for (final T t : collection) {
            if (equalator.areEqual(key, t)) {
                return t;
            }
        }
        return null;
    }

    /**
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
    public static <T> T getHighest(final Collection<? extends T> elements, final Comparator<T> c) {
        T result = null;
        for (final T e : elements) {
            if (result == null) {
                result = e;
            } else {
                final int i = c.compare(e, result);
                if (i > 0)
                    result = e;
            }
        }
        return result;
    }

    public static <T> Collection<T> getIntersection(final Collection<T> a, final Collection<T> b) {
        return getIntersection(a, b, new ArrayListFactory<T>());
    }

    public static <T> Collection<T> getIntersection(final Collection<T> a, final Collection<T> b,
            final FactoryCollection<T> factory) {
        final Collection<T> result = factory.createCollection();
        for (final T t : a) {
            if (b.contains(t)) {
                result.add(t);
            }
        }
        return result;
    }

    /**
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
    public static <T> T getLowest(final Collection<? extends T> elements, final Comparator<T> c) {
        return getHighest(elements, new ComparatorInverter<T>(c));
    }

    public static int getNumberOfNonEmptyElements(final Iterable<Collection<?>> col) {
        if (col == null)
            return 0;
        int result = 0;
        for (final Collection<?> o : col) {
            if (o != null && !o.isEmpty()) {
                result++;
            }
        }
        return result;
    }

    public static int getNumberOfNonNullElements(final Collection<?> col) {
        if (col == null)
            return 0;
        int result = 0;
        for (final Object o : col) {
            if (o != null) {
                result++;
            }
        }
        return result;
    }

    public static <T> Collection<Collection<T>> getSame(final Collection<? extends T> c, final Equalator<T> equalator) {
        final Collection<Collection<T>> result = newCollection();
        final List<T> listCopy = new ArrayList<T>(c);
        ListIterator<T> it1 = listCopy.listIterator();
        while (it1.hasNext()) {
            final T t1 = it1.next();
            final int index = it1.nextIndex();
            final ListIterator<T> it2 = listCopy.listIterator(index);
            final Collection<T> result2 = newCollection();
            result2.add(t1);
            while (it2.hasNext()) {
                final T t2 = it2.next();
                if (equalator.areEqual(t1, t2)) {
                    result2.add(t2);
                    it2.remove();
                    it1 = listCopy.listIterator();
                }
            }
            if (result2.size() > 1) {
                result.add(result2);
            }
        }
        return result;
    }

    public static <T> Collection<Collection<T>> getSame(final Collection<T> c) {
        return getSame(c, new EqualatorDefault<T>());
    }

    public static <C> Collection<C> iteratorToCollection(final Iterable<? extends C> iterable) {
        return iteratorToCollection(iterable, new ArrayListFactory<C>());
    }

    public static <C> Collection<C> iteratorToCollection(final Iterable<? extends C> iterable,
            final FactoryCollection<C> factory) {
        final Collection<C> result = factory.createCollection();
        final Iterator<? extends C> it = iterable.iterator();
        while (it.hasNext()) {
            result.add(it.next());
        }
        return result;
    }

    public static <T> Collection<T> newCollection() {
        return UtilList.newList();
    }

    public static <T> Collection<T> newCollection(final Collection<? extends T> template) {
        return UtilList.newList(template);
    }

    public static <T> Collection<T> newCollection(final T... template) {
        return UtilList.newList(template);
    }

    public static <T> ObjectPairSameImpl<T> nextTwo(final Iterator<T> iterator) {
        T first = null, second = null;
        if (iterator.hasNext()) {
            first = iterator.next();
        }
        if (iterator.hasNext()) {
            second = iterator.next();
        }
        if (first != null && second != null) {
            return new ObjectPairSameImpl<T>(first, second);
        } else {
            return null;
        }
    }

    /**
     * Check if a {@link Collection} or all of its elements is/ are {@code null}
     * .
     * 
     * @param col
     *            {@link Collection} to check
     * @return true, if given {@link Collection} or all of its elements is/ are
     *         {@code null}; {@code false} otherwise
     */
    public static boolean nullCollection(final Collection<?> col) {
        if (col == null)
            return true;
        for (final Object o : col) {
            if (o != null)
                return false;
        }
        return true;
    }

    public static void removeNull(final Collection<?> c) {
        for (final Iterator<?> it = c.iterator(); it.hasNext();) {
            final Object object = it.next();
            if (object == null) {
                it.remove();
            }
        }
    }

    public static <O> String toString(final Iterable<? extends O> it, final String objectSeparator) {
        return toString(it, TRANSFORMER_TO_STRING_DEFAULT, objectSeparator);
    }

    public static <O> String toString(final Iterable<? extends O> it, final Transformer<Object, String> s) {
        return toString(it, s, DEFAULT_OBJECT_SEPARATOR);
    }

    public static <O> String toString(final Iterable<? extends O> iterable,
            final Transformer<Object, String> transformer, final String objectSeparator) {
        final StringBuilder sb = new StringBuilder();
        final Iterator<? extends O> it = iterable.iterator();
        while (it.hasNext()) {
            sb.append(transformer.transform(it.next()));
            if (it.hasNext())
                sb.append(objectSeparator);
        }
        return sb.toString();
    }

    /**
     * Simple {@code toString()} method, which calls each element's
     * {@code toString()} and appends after that
     * {@link UtilStrings#NEW_LINE_STRING}.
     * 
     * @return String representation for given {@code Collection}, or empty
     *         string if parameter is empty
     */
    public static String toString(final Iterable<?> elements) {
        if (!elements.iterator().hasNext())
            return "";
        final StringBuilder b = new StringBuilder();
        b.append(UtilString.NEW_LINE_STRING);
        final Iterator<?> i = elements.iterator();
        while (i.hasNext()) {
            b.append(i.next());
            if (i.hasNext())
                b.append(UtilString.NEW_LINE_STRING);
        }
        return b.toString();
    }

    public static <O> String toString(final ListIterator<? extends O> it, final VisitorList<String, O> s) {
        return toString(it, s, DEFAULT_OBJECT_SEPARATOR);
    }

    public static <O> String toString(final ListIterator<? extends O> it, final VisitorList<String, O> visitor,
            final String objectSeparator) {
        final StringBuilder sb = new StringBuilder();
        while (it.hasNext()) {
            final int index = it.nextIndex();
            sb.append(visitor.visit(it.next(), index));
            if (it.hasNext())
                sb.append(objectSeparator);
        }
        return sb.toString();
    }

    private UtilCollection() {
        // Singleton
    }
}

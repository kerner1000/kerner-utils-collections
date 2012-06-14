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

package net.sf.kerner.utils.collections.list.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import net.sf.kerner.utils.TransformerToString;
import net.sf.kerner.utils.TransformerToStringDefault;
import net.sf.kerner.utils.collections.impl.CollectionUtils;
import net.sf.kerner.utils.collections.list.FilterList;
import net.sf.kerner.utils.collections.list.ListFactory;
import net.sf.kerner.utils.collections.list.impl.filter.FilterNull;

/**
 * 
 * Utility class for {@link List} related stuff.
 * 
 * @author <a href="mailto:alex.kerner.24@googlemail.com">Alexander Kerner</a>
 * @version 2012-04-16
 * 
 */
public class ListUtils {

	public final static TransformerToString TRANSFORMER_TO_STRING_DEFAULT = new TransformerToStringDefault();

	private ListUtils() {
		// Singleton
	}

	/**
	 * 
	 * Combine two {@link java.util.List Lists} into one. </p> Elements, that
	 * have same position in both lists and are equal to each other are filtered
	 * out. </p> {@code null equals null}. {@code null} is kept in list only, if
	 * at this position in both list elemnt is {@code null} or other list does
	 * not have this position. </p> Resulting list size is always equal to size
	 * of longer list.
	 * 
	 * @param <C>
	 * @param c1
	 *            first list
	 * @param c2
	 *            second list
	 * @param factory
	 *            {@link net.sf.kerner.utils.collections.list.ListFactory
	 *            ListFactory} that provides instance of returning list
	 * @return a new {@link java.util.List List}
	 */
	public static <C> List<C> meld(List<? extends C> c1, List<? extends C> c2,
			ListFactory<C> factory) {
		final List<C> result = factory.createCollection();
		Iterator<? extends C> i1 = c1.iterator();
		Iterator<? extends C> i2 = c2.iterator();

		while (i1.hasNext()) {
			final C e1 = i1.next();
			if (i2.hasNext()) {
				final C e2 = i2.next();

				if (e1 == null && e2 == null)
					result.add(null);

				else if (e1 == null)
					result.add(e2);

				else if (e2 == null)
					result.add(e1);

				else if (e1.equals(e2))
					result.add(e1);

				else {
					result.add(e1);
					result.add(e2);
				}

			} else
				result.add(e1);
		}

		while (i2.hasNext()) {
			final C e2 = i2.next();
			result.add(e2);
		}
		return result;
	}

	public static <C> List<C> meld(List<? extends C> c1, List<? extends C> c2) {
		if (c1 == null && c2 == null)
			return new ArrayListFactory<C>().createCollection();
		if (c1 == null)
			return new ArrayListFactory<C>().createCollection(c2);
		if (c2 == null)
			return new ArrayListFactory<C>().createCollection(c1);
		return meld(c1, c2, new ArrayListFactory<C>());
	}

	public static <E> void fill(List<E> list, int numElements, E e) {
		if (numElements < list.size())
			return;
		final int iterations = numElements - list.size();
		for (int i = 0; i < iterations; i++) {
			list.add(e);
		}
	}

	public static <E> List<String> toStringList(Collection<E> elements) {
		return new TransformerToStringCollection().transformCollection(elements);
	}

	public static <E> List<String> toStringList(TransformerToString strategy, Collection<E> elements) {
		return new TransformerToStringCollection(strategy).transformCollection(elements);
	}

	public static <L> List<L> append(Collection<? extends L> c1, Collection<? extends L> c2) {
		return (List<L>) CollectionUtils.append(c1, c2, new ArrayListFactory<L>());
	}

	public static <V> List<V> trimm(List<? extends V> list, ListFactory<V> factory) {
		final List<V> result = factory.createCollection();
		for (V o : list) {
			if (o != null)
				result.add(o);
		}
		return result;
	}

	public static <C> List<C> filterList(List<? extends C> collection, FilterList<C> filter,
			ListFactory<C> factory) {
		final List<C> result = factory.createCollection();
		for (int i = 0; i < collection.size(); i++) {
			final C c = collection.get(i);
			if (filter.visit(c, i))
				result.add(c);
		}
		return result;
	}

	public static <C> List<C> filterList(List<? extends C> collection, FilterList<C> filter) {
		return filterList(collection, filter, new ArrayListFactory<C>());
	}

	public static <T> void setAll(List<T> parent, List<T> sublist, int index) {
		if (parent.size() < sublist.size())
			throw new IllegalArgumentException("parent too small for child");
		if (parent.size() < sublist.size() + index)
			throw new IllegalArgumentException("parent too small for index");
		if (index < 0)
			throw new IllegalArgumentException("invalid index " + index);
		for (int i = 0; i < sublist.size(); i++) {
			parent.set(i + index, sublist.get(i));
		}
	}

	public static void removeAll(List<?> list, Collection<Integer> indices) {
		ListIterator<?> it = list.listIterator();
		while (it.hasNext()) {
			int index = it.nextIndex();
			it.next();
			if (indices.contains(index)) {
				it.remove();
			}
		}
	}

	public static <T> List<T> removeAll(List<T> list, List<T> values) {
		final List<T> copy = new ArrayList<T>(list);
		copy.removeAll(values);
		return copy;
	}

	public static void retainAll(List<?> list, Collection<Integer> indices) {
		ListIterator<?> it = list.listIterator();
		while (it.hasNext()) {
			int index = it.nextIndex();
			it.next();
			if (indices.contains(index)) {
				// ok
			} else {
				it.remove();
			}
		}
	}

	public static <T> List<T> removeAll2(List<T> list, Collection<Integer> indices,
			ListFactory<T> factory) {
		final List<T> copy = factory.createCollection(list);
		removeAll(copy, indices);
		return copy;
	}

	public static <T> List<T> retainAll2(List<T> list, Collection<Integer> indices,
			ListFactory<T> factory) {
		final List<T> copy = factory.createCollection(list);
		retainAll(copy, indices);
		return copy;
	}

	public static <T> List<T> removeAll2(List<T> list, Collection<Integer> indices) {
		return removeAll2(list, indices, new ArrayListFactory<T>());
	}

	public static <T> List<T> retainAll2(List<T> list, Collection<Integer> indices) {
		return retainAll2(list, indices, new ArrayListFactory<T>());
	}

	public static <T> T getFirstElement(List<T> list) {
		if (list.size() < 1) {
			throw new IllegalArgumentException("list is empty");
		}
		return list.get(0);
	}

	public static <T> T getLastElement(List<T> list) {
		if (list.size() < 1) {
			throw new IllegalArgumentException("list is empty");
		}
		return list.get(list.size() - 1);
	}
	
	public static <T> void prepend(List<T> list, int numElements, T element){
		for(int i=0; i<list.size(); i++){
			list.add(0, element);
		}
	}
	
	public static <T> void append(List<T> list, int numElements, T element){
		for(int i=0; i<numElements; i++){
			list.add(element);
		}
	}

	public static <T> List<T> newList() {
		return new ArrayList<T>();
	}
	
	public static <T> List<T> newList(Collection<? extends T> elements) {
		return new ArrayList<T>(elements);
	}
	
	public static <T> List<T> newList(T... elements) {
		return Arrays.asList(elements);
	}
	
	public static <T> List<T> newList(Collection<? extends T>... elements) {
		final List<T> result = newList();
		for(Collection<? extends T> c : elements){
			result.addAll(c);
		}
		return result;
	} 
	
	public static int getFirstNonNullIndex(List<?> list){
		for(int i=0; i< list.size(); i++){
			final Object o = list.get(i);
			if(o != null){
				return i;
			}
		}
		return -1;
	}
	
	public static int getLastNonNullIndex(List<?> list){
		for(int i=list.size() - 1; i >= 0; i--){
			final Object o = list.get(i);
			if(o != null){
				return i;
			}
		}
		return -1;
	}
	
	public static int getFirstNonEmptyIndex(List<Collection<?>> list){
		for(int i=0; i< list.size(); i++){
			final Collection<?> o = list.get(i);
			if(o != null && !o.isEmpty()){
				return i;
			}
		}
		return -1;
	}
	
	public static <T> List<T> filterNull(List<T> list){
		return filterList(list, new FilterNull<T>());
	}
	
	public static List<Object> toObjectList(Collection<? extends Object> elements){
		return newList(elements);
	}

}

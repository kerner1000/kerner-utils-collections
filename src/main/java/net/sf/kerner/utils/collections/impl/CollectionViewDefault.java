package net.sf.kerner.utils.collections.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import net.sf.kerner.utils.collections.CollectionView;
import net.sf.kerner.utils.collections.Filter;

public class CollectionViewDefault<T> implements CollectionView<T> {

	protected final Collection<T> collection;

	public CollectionViewDefault(Collection<T> collection, Filter<T> filter) {
		this.collection = new ArrayList<T>();
		for (T t : collection) {
			if (filter.visit(t))
				this.collection.add(t);
		}
	}

	public CollectionView<T> getView(Filter<T> filter) {
		return new CollectionViewDefault<T>(collection, filter);
	}

	public int size() {
		return collection.size();
	}

	public boolean isEmpty() {
		return collection.isEmpty();
	}

	public boolean contains(Object o) {
		return collection.contains(o);
	}

	public Iterator<T> iterator() {
		return collection.iterator();
	}

	public Object[] toArray() {
		return collection.toArray();
	}

	@SuppressWarnings("hiding")
	public <T> T[] toArray(T[] a) {
		return collection.toArray(a);
	}

	public boolean add(T e) {
		return collection.add(e);
	}

	public boolean remove(Object o) {
		return collection.remove(o);
	}

	public boolean containsAll(Collection<?> c) {
		return collection.containsAll(c);
	}

	public boolean addAll(Collection<? extends T> c) {
		return collection.addAll(c);
	}

	public boolean removeAll(Collection<?> c) {
		return collection.removeAll(c);
	}

	public boolean retainAll(Collection<?> c) {
		return collection.retainAll(c);
	}

	public void clear() {
		collection.clear();
	}

	public boolean equals(Object o) {
		return collection.equals(o);
	}

	public int hashCode() {
		return collection.hashCode();
	}

	@Override
	public String toString() {
		return collection.toString();
	}

}

package net.sf.kerner.utils.collections.list.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import net.sf.kerner.utils.collections.CollectionView;
import net.sf.kerner.utils.collections.Filter;
import net.sf.kerner.utils.collections.list.ListFilter;
import net.sf.kerner.utils.collections.list.ListView;

public class ArrayListView<T> implements ListView<T>, List<T> {
	
	protected final List<T> collection;
	
	public ArrayListView(List<? extends T> collection, ListFilter<T> filter) {
		this.collection = new ArrayList<T>();
		for(int i=0; i<collection.size(); i++){
			final T t = collection.get(i);
			if(filter.visit(t, i)){
				this.collection.add(t);
			}
		}
	}

	public ArrayListView(Collection<? extends T> collection, Filter<T> filter) {
		this.collection = new ArrayList<T>();
		for(T t : collection){
			if(filter.visit(t)){
				this.collection.add(t);
			}
		}
	}
	
	public ArrayListView(Collection<? extends T> collection) {
		this.collection = new ArrayList<T>(collection);
	}
	
	public ListView<T> getView(final Filter<T> filter) {
		return new ArrayListView<T>(collection, filter);
	}
	
	public ListView<T> getView(final ListFilter<T> filter) {
		return new ArrayListView<T>(collection, filter);
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

	public boolean addAll(int index, Collection<? extends T> c) {
		return collection.addAll(index, c);
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

	public T get(int index) {
		return collection.get(index);
	}

	public T set(int index, T element) {
		return collection.set(index, element);
	}

	public void add(int index, T element) {
		collection.add(index, element);
	}

	public T remove(int index) {
		return collection.remove(index);
	}

	public int indexOf(Object o) {
		return collection.indexOf(o);
	}

	public int lastIndexOf(Object o) {
		return collection.lastIndexOf(o);
	}

	public ListIterator<T> listIterator() {
		return collection.listIterator();
	}

	public ListIterator<T> listIterator(int index) {
		return collection.listIterator(index);
	}

	public List<T> subList(int fromIndex, int toIndex) {
		return collection.subList(fromIndex, toIndex);
	}
	
	

	
	

}

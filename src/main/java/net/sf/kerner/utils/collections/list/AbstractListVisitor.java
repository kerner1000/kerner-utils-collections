package net.sf.kerner.utils.collections.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

import net.sf.kerner.utils.collections.Filter;

public abstract class AbstractListVisitor<V, E> implements ListWalker<E>, ListVisitor<V, E> {

	protected final Collection<Filter<E>> filters = new ArrayList<Filter<E>>();

	protected volatile ListIterator<? extends E> iterator;

	public synchronized void addFilter(Filter<E> filter) {
		filters.add(filter);
	}

	public synchronized void clearFilters() {
		filters.clear();
	}

	public void beforeWalk() {

	}

	public void walk(List<? extends E> list) {
		iterator = list.listIterator();
		synchronized (iterator) {
			beforeWalk();
			while (iterator.hasNext()) {
					final E e = iterator.next();
					boolean take = true;
					for (Filter<E> f : filters) {
						if (f.visit(e)) {
							// take
						} else {
							take = false;
							break;
						}
					}
					if (take)
						handleVisit(visit(e));
			}
			afterWalk();
		}
	}

	public void afterWalk() {

	}
	
	public ListIterator<? extends E> getIterator() {
		return iterator;
	}

	protected abstract void handleVisit(V v);

}

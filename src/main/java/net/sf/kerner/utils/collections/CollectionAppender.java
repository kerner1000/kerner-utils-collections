
package net.sf.kerner.utils.collections;

import java.util.Arrays;
import java.util.Collection;

import net.sf.kerner.utils.collections.filter.Filter;
import net.sf.kerner.utils.collections.filter.FilterApplierProto;
import net.sf.kerner.utils.collections.list.ArrayListFactory;

public class CollectionAppender<T> {

    public final FactoryCollection<T> DEFAULT_FACTORY_COLLECTION = new ArrayListFactory<T>();

    private FactoryCollection<T> factoryCollection = DEFAULT_FACTORY_COLLECTION;

    private Filter<? super T> filter;

    @SuppressWarnings("unchecked")
    public synchronized Collection<T> append(final Collection<? extends Collection<? extends T>> collections) {
	final FilterApplierProto fa = new FilterApplierProto();
	if (filter != null) {
	    fa.addFilter(filter);
	}
	final Collection<T> result = getFactoryCollection().createCollection();
	for (final Collection<? extends T> c : collections) {
	    result.addAll(fa.filter(c));
	}
	return result;
    }

    public synchronized Collection<T> append(final Collection<? extends T>... collections) {
	return append(Arrays.asList(collections));
    }

    public synchronized FactoryCollection<T> getFactoryCollection() {

	return factoryCollection;
    }

    public synchronized Filter<? super T> getFilter() {

	return filter;
    }

    public synchronized CollectionAppender<T> setFactoryCollection(final FactoryCollection<T> factoryCollection) {

	this.factoryCollection = factoryCollection;
	return this;
    }

    public synchronized CollectionAppender<T> setFilter(final Filter<? super T> filter) {

	this.filter = filter;
	return this;
    }
}

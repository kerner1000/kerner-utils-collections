/*******************************************************************************
 * Copyright (c) 2016 <a href="mailto:alexander.kerner@openchrom.net">Alexander Kerner</a>.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * <a href="mailto:alexander.kerner@openchrom.net">Alexander Kerner</a> - initial API and implementation
*******************************************************************************/
package net.sf.kerner.utils.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import net.sf.kerner.utils.collections.filter.Filter;
import net.sf.kerner.utils.collections.filter.FilterApplierProto;
import net.sf.kerner.utils.collections.list.ArrayListFactory;

public class CollectionAppender<T> {
	
	public final FactoryCollection<T> DEFAULT_FACTORY_COLLECTION = new ArrayListFactory<T>();
	
	private FactoryCollection<T> factoryCollection = DEFAULT_FACTORY_COLLECTION;
	
	
	public synchronized FactoryCollection<T> getFactoryCollection() {
	
		return factoryCollection;
	}


	
	public synchronized CollectionAppender<T> setFactoryCollection(FactoryCollection<T> factoryCollection) {
	
		this.factoryCollection = factoryCollection;
		return this;
	}

	private Filter<? super T> filter;
	
	
	public synchronized Filter<? super T> getFilter() {
	
		return filter;
	}

	
	public synchronized CollectionAppender<T> setFilter(Filter<? super T> filter) {
	
		this.filter = filter;
		return this;
	}

	public synchronized Collection<T> append(Collection<? extends T>... collections){
		return append(Arrays.asList(collections));
	}
	
	@SuppressWarnings("unchecked")
	public synchronized Collection<T> append(Collection<? extends Collection<? extends T>> collections){
		FilterApplierProto fa = new FilterApplierProto();
		if(filter != null){
			fa.addFilter(filter);
		}
		Collection<T> result = getFactoryCollection().createCollection();
		for(Collection<? extends T> c : collections){
			result.addAll(fa.filter(c));
		}
		return result;
	}
}

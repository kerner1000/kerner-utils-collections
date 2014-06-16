/*******************************************************************************
 * Copyright (c) 2010-2014 Alexander Kerner. All rights reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package net.sf.kerner.utils.collections.filter.impl;

import java.util.List;

import net.sf.kerner.utils.collections.applier.Applier;
import net.sf.kerner.utils.collections.filter.Filter;
import net.sf.kerner.utils.collections.filter.FilterApplier;
import net.sf.kerner.utils.collections.visitor.Visitor;
import net.sf.kerner.utils.collections.visitor.VisitorApplierDefault;
import net.sf.kerner.utils.collections.visitor.VisitorApplierDefaultProto;

public class FilterVisitorApplierProto<E> implements FilterApplier<E>, VisitorApplierDefault<E> {

    private final FilterApplierProto<E> filterDelegate = new FilterApplierProto<E>();

    private final VisitorApplierDefaultProto<E> visitorDelegate = new VisitorApplierDefaultProto<E>();

    public FilterVisitorApplierProto<E> addFilter(final Filter<E> filter) {
        filterDelegate.addFilter(filter);
        return this;
    }

    public void addVisitor(final Visitor<Void, E> visitor) {
        visitorDelegate.addVisitor(visitor);
    }

    public void clear() {
        filterDelegate.clear();
    }

    public void clearVisitors() {
        visitorDelegate.clearVisitors();
    }

    public boolean filter(final E e) {
        final boolean b = filterDelegate.filter(e);
        if (b) {
            visitorDelegate.visit(e);
        }
        return b;
    }

    public List<Filter<E>> getFilters() {
        return filterDelegate.getFilters();
    }

    public boolean isEmpty() {
        return filterDelegate.isEmpty();
    }

    public void setFilterType(final Applier.TYPE filterType) {
        this.filterDelegate.setFilterType(filterType);
    }

    public Void visit(final E e) {
        if (filter(e)) {
            visitorDelegate.visit(e);
        }
        return null;
    }
}

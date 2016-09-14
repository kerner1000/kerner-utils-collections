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
package net.sf.kerner.utils.collections.list;

import java.util.List;
import java.util.ListIterator;

import net.sf.kerner.utils.collections.list.filter.FilterVisitorListApplierProto;

public class ListWalkerDefault<E> extends FilterVisitorListApplierProto<E> implements ListWalker<E> {

    public void afterWalk() {
	// do nothing by default
    }

    public void beforeWalk() {
	// do nothing by default
    }

    public void walk(final List<? extends E> list) {
	synchronized (list) {
	    beforeWalk();
	    for (final ListIterator<? extends E> it = list.listIterator(); it.hasNext();) {
		final int index = it.nextIndex();
		final E e = it.next();
		visit(e, index);
	    }
	    afterWalk();
	}
    }
}

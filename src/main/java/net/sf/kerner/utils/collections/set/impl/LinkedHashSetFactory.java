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

package net.sf.kerner.utils.collections.set.impl;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

import net.sf.kerner.utils.collections.set.SetFactory;

/**
 * 
 * A {@link SetFactory} builds a {@link LinkedHashSet}.
 * 
 * @author <a href="mailto:alex.kerner.24@googlemail.com">Alexander Kerner</a>
 * @version 2012-04-02
 * 
 * @param <E>
 *            type of elements contained by the {@code Set}
 */
public class LinkedHashSetFactory<E> implements SetFactory<E> {

	/** 
	 * 
	 */
	public Set<E> createCollection() {
		return new LinkedHashSet<E>();
	}

	/**
	 * 
	 */
	public Set<E> createCollection(Collection<? extends E> template) {
		return new LinkedHashSet<E>(template);
	}

}

/**********************************************************************
Copyright (c) 2009-2010 Alexander Kerner. All rights reserved.
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
import java.util.List;

import net.sf.kerner.utils.collections.list.ListFactory;

/**
 * A {@link net.sf.kerner.utils.collections.list.ListFactory ListFactory} that
 * returns instances of {@link java.util.ArrayList ArrayList}.
 * 
 * @author <a href="mailto:alex.kerner.24@googlemail.com">Alexander Kerner</a>
 * @version 2010-12-20
 * 
 */
public class ArrayListFactory<E> extends AbstractListFactory<E> implements ListFactory<E> {

	public ArrayListFactory() {
		super();
	}

	public ArrayListFactory(List<? extends E> template) {
		super(template);
	}

	@Override
	protected List<E> getListImpl() {
		return new ArrayList<E>();
	}

}

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

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import net.sf.kerner.utils.collections.list.ListFactory;

/**
 * 
 * Utility class for {@link java.util.List List} related stuff.
 * 
 * @author <a href="mailto:alex.kerner.24@googlemail.com">Alexander Kerner</a>
 * @version 2010-12-03
 * 
 */
public class ListUtils {
	
	private ListUtils(){}
	
	public static <C> List<C> meld(List<? extends C> c1, List<? extends C> c2, ListFactory<C> factory){
		final List<C> result = factory.createCollection();
		Iterator<? extends C> i1 = c1.iterator();
		Iterator<? extends C> i2 = c2.iterator();
		while(i1.hasNext()){
			C c11 = i1.next();
			result.add(c11);
			if(i2.hasNext()){
				C c22 = i2.next();
				if(c11.equals(c22)){
					// System.err.println("skipping " + c22);
				} else
				result.add(c22);
			}
		}
		while(i2.hasNext())
			result.add(i2.next());
		return result;
	}
	
	public static <C> List<C> meld(List<? extends C> c1, List<? extends C> c2){
		return meld(c1, c2, new ArrayListFactory<C>());
	}
	
	/**
	 * 
	 * 
	 * Fill given {@link java.util.List List}. That is to add
	 * 
	 * <pre>
	 * {@code numElements-list.size()-1}
	 * </pre>
	 * 
	 * elements to this {@code List}, resulting in a new list size of
	 * {@code numElements}. If {@code numElements < list.size()}, this
	 * method does nothing.
	 * 
	 * @param <E>
	 *            type of element that is used for filling this {@code List}
	 * @param list
	 *            the {@code List} that is filled
	 * @param numElements
	 *            new {@link java.util.List#size()} of this {@code List}
	 * @param e
	 *            element which is used to fill the list
	 *            
	 * @see java.util.List
	 */
	public static <E> void fill(List<E> list, int numElements, E e) {
		if (numElements < list.size())
			return;
		final int iterations = numElements - list.size() - 1;
		for (int i = 0; i <= iterations; i++) {
			list.add(e);
		}
	}
	
	public static List<String> toStringList(Object...objects){
		return new ToStringListTransformer().transformCollection(Arrays.asList(objects));
	}

}

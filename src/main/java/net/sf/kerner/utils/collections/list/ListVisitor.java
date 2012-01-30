/**********************************************************************
Copyright (c) 2009-2011 Alexander Kerner. All rights reserved.
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

package net.sf.kerner.utils.collections.list;

import java.util.List;
import java.util.ListIterator;

import net.sf.kerner.utils.collections.Visitor;

/**
 * 
 * An extension to {@link Visitor}, which additionally provides a
 * {@link ListIterator} as a parameter (to the closure/ function), that gives
 * access to {@link List} that is visited by this {@code Visitor}.
 * 
 * <p>
 * <b>Example:</b><br>
 * 
 * </p>
 * <p>
 * 
 * <pre>
 * TODO example
 * </pre>
 * 
 * </p>
 * 
 * @author <a href="mailto:alex.kerner.24@googlemail.com">Alexander Kerner</a>
 * @version 2011-11-03
 * 
 * @param <R>
 *            type of result
 * @param <E>
 *            type of input
 */
public interface ListVisitor<R, E> extends Visitor<R, E> {

	/**
	 * 
	 * Visit object {@code e}, perform any action and return result.
	 * 
	 * @param element
	 *            element to visit
	 * @param iterator
	 *            {@link ListIterator} that gives direct access to {@link List}
	 *            that contains elements which are visited
	 * @return result of visit
	 */
	R visit(E e, ListIterator<? extends E> iterator);

}

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

package net.sf.kerner.utils.collections;

import java.util.Collection;

/**
 * 
 * A {@code Selector} selects and returns an instance of one element out of a
 * given {@link java.util.Collection Collection} of elements. Returned instance
 * of element ist not altered and stays a member of input
 * {@link java.util.Collection Collection}.
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
 * @version 2011-06-06
 * 
 * @param <T>
 */
public interface Selector<T> {

	/**
	 * 
	 * Select one element from given {@code Collection} that fits this
	 * {@code Selector's} needs.
	 * 
	 * @param elements
	 *            {@link java.util.Collection Collection} of elements from which
	 *            one should be selected
	 * @return element that was selected by this {@code Selector}
	 */
	T select(Collection<? extends T> elements);

}

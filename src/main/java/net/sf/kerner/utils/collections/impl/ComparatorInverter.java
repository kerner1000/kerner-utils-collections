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

package net.sf.kerner.utils.collections.impl;

import java.util.Comparator;

/**
 * 
 * Simple class to invert the comparison logic of another {@link Comparator}.
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
 * @version 2011-10-26
 * 
 * @see Comparator
 * 
 * @param <E>
 *            type of elements which are compared
 */
public class ComparatorInverter<T> implements Comparator<T> {

	protected final Comparator<T> c;

	public ComparatorInverter(Comparator<T> c) {
		this.c = c;
	}

	public int compare(T o1, T o2) {
		final int r = c.compare(o1, o2);
		if (r < 0)
			return 1;
		if (r > 0)
			return -1;
		return r;
	}

}

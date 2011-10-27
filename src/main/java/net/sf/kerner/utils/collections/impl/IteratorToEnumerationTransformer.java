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

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

import net.sf.kerner.utils.transformer.Transformer;

/**
 * 
 * Transforms an {@link java.util.Iterator Iterator} to an
 * {@link java.util.Enumeration Enumeration}.
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
 * @version 2011-07-06
 * 
 * @param <T>
 *            type of element
 */
public class IteratorToEnumerationTransformer<T> implements
		Transformer<Iterator<T>, Enumeration<T>> {

	/**
	 * 
	 */
	public Enumeration<T> transform(Iterator<T> element) {
		final Vector<T> v = new Vector<T>();
		while (element.hasNext())
			v.add(element.next());
		return v.elements();
	}

}

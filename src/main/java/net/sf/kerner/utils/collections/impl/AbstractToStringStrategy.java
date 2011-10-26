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

package net.sf.kerner.utils.collections.impl;

import net.sf.kerner.utils.collections.ToStringStrategy;

/**
 * 
 * Prototype implementation for {@link ToStringStrategy}. {@link #toString()}
 * will call {@link #visit(Object)} using object that was passed via
 * constructor.
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
 * @param <E>
 *            type of object
 */
public abstract class AbstractToStringStrategy<E> implements ToStringStrategy<E> {

	protected final E e;

	/**
	 * 
	 * Construct a new {@code AbstractToStringStrategy}.
	 * 
	 * @param e
	 *            object that will be visited on call of {@link #toString()}
	 */
	public AbstractToStringStrategy(E e) {
		super();
		this.e = e;
	}

	@Override
	public String toString() {
		if (e == null)
			return "null";
		return visit(e);
	}

}

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

package net.sf.kerner.utils.collections;

/**
 * 
 * <a href="http://de.wikipedia.org/wiki/Visitor">Wikipedia: Visitor Pattern</a>
 * 
 * <p>
 * <b>Example:</b><br>
 *
 * </p>
 * <p>
 * <pre>
 * TODO example
 * </pre>
 * </p>
 *
 * @author <a href="mailto:alex.kerner.24@googlemail.com">Alexander Kerner</a>
 * @version 2011-10-26
 *
 * @param <R> type of result
 * @param <E> type of input object
 */
public interface Visitor<R, E> {

	/**
	 * 
	 * Visit object {@code element}, perform any action and return result.
	 *
	 * @param element element to visit
	 * @return result of visit
	 */
	R visit(E element);
	
}

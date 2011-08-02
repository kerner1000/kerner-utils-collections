package net.sf.kerner.utils.collections.impl;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

import net.sf.kerner.utils.transformer.Transformer;

/**
 * 
 * Transforms an {@link java.util.Iterator Iterator} to an {@link java.util.Enumeration Enumeration}.
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
 * @version 2011-07-06
 *
 * @param <T> type of element
 */
public class IteratorToEnumerationTransformer<T> implements Transformer<Iterator<T>, Enumeration<T>> {

	/**
	 * 
	 */
	public Enumeration<T> transform(Iterator<T> element) {
		final Vector<T> v = new Vector<T>();
		while(element.hasNext())
			v.add(element.next());
		return v.elements();
	}

}

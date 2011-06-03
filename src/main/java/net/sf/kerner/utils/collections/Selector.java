package net.sf.kerner.utils.collections;

import java.util.Collection;

/**
 * 
 * A {@code Selector} selects and returns an instance of one element out of a
 * given {@link java.util.Collection Collection} of elements.
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
 * @version 2011-06-03
 * 
 * @param <T>
 */
public interface Selector<T> {

	/**
	 * 
	 * TODO description
	 *
	 * @param elements {@link java.util.Collection Collection} of elements from which one should be selected
	 * @return element that was selected by this {@code Selector}
	 */
	T select(Collection<T> elements);

}

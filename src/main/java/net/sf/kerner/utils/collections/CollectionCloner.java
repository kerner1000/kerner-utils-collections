/*******************************************************************************
 * Copyright (c) 2016 <a href="mailto:alexander.kerner@openchrom.net">Alexander Kerner</a>.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * <a href="mailto:alexander.kerner@openchrom.net">Alexander Kerner</a> - initial API and implementation
 *******************************************************************************/
package net.sf.kerner.utils.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import net.sf.kerner.utils.Cloneable;

public class CollectionCloner {

	public static <T extends Cloneable<T>> Collection<T> clone(final Collection<? extends T> list) {

		final List<T> result = new ArrayList<T>();
		for(final T t : list) {
			result.add(t.clone());
		}
		return result;
	}
}

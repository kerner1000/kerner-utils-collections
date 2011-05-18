package net.sf.kerner.utils.collections.list.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import net.sf.kerner.utils.collections.CollectionTransformer;

public class ToStringListTransformer implements CollectionTransformer<Object, String> {

	public List<String> transformCollection(
			Collection<? extends Object> element) {
		final List<String> result = new ArrayList<String>();
		for (Object o : element) {
			result.add(o.toString());
		}
		return result;
	}
}

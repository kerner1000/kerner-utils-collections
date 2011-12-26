package net.sf.kerner.utils.collections.list.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import net.sf.kerner.utils.collections.CollectionTransformer;
import net.sf.kerner.utils.collections.ToStringStrategy;

public class ToStringListTransformer implements CollectionTransformer<Object, String> {
	
	public final static ToStringStrategy<Object> DEFAULT_TO_STRING_STRATEGY = new ToStringStrategy<Object>() {

		public String visit(Object element) {
			return element.toString();
		}
	};
	
	private final ToStringStrategy<Object> s;
	
	public ToStringListTransformer() {
		s = DEFAULT_TO_STRING_STRATEGY;
	}
	
	public ToStringListTransformer(ToStringStrategy<Object> s) {
		this.s = s;
	}

	public List<String> transformCollection(
			Collection<? extends Object> element) {
		final List<String> result = new ArrayList<String>();
		for (Object o : element) {
			result.add(s.visit(o));
		}
		return result;
	}
}

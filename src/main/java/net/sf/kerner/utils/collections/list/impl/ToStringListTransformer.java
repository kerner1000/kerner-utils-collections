package net.sf.kerner.utils.collections.list.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import net.sf.kerner.utils.collections.TransformerCollection;
import net.sf.kerner.utils.collections.ToStringStrategy;

public class ToStringListTransformer<E> implements TransformerCollection<E, String> {

	public final ToStringStrategy<E> defaultToStringStrategy = new ToStringStrategy<E>() {
		public String transform(Object element) {
			if(element == null){
				return "null";
			}
			return element.toString();
		}
	};

	private final ToStringStrategy<E> s;

	public ToStringListTransformer() {
		s = defaultToStringStrategy;
	}

	public ToStringListTransformer(ToStringStrategy<E> s) {
		this.s = s;
	}

	public List<String> transformCollection(Collection<? extends E> element) {
		final List<String> result = new ArrayList<String>();
		for (E o : element) {
			result.add(s.transform(o));
		}
		return result;
	}
}

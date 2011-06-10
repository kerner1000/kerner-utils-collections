package net.sf.kerner.utils.collections.list.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import net.sf.kerner.utils.collections.list.TransformingListFactory;
import net.sf.kerner.utils.transformer.Transformer;

public abstract class AbstractTransformingListFactory<S, E> implements TransformingListFactory<S, E>, Transformer<S, E>{
	
	public List<E> createCollection(Collection<? extends S> elements) {
		final List<E> result = new ArrayList<E>();
		for(S s : elements){
			result.add(transform(s));
		}
		return result;
	}

}

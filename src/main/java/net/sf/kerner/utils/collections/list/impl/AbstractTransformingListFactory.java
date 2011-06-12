package net.sf.kerner.utils.collections.list.impl;

import java.util.Collection;
import java.util.List;

import net.sf.kerner.utils.collections.list.TransformingListFactory;
import net.sf.kerner.utils.transformer.Transformer;

public abstract class AbstractTransformingListFactory<S, E> implements
		TransformingListFactory<S, E>, Transformer<S, E> {

	private final List<? extends S> template;

	public AbstractTransformingListFactory() {
		this.template = null;
	}

	public AbstractTransformingListFactory(List<? extends S> template) {
		this.template = template;
	}

	public List<E> createCollection() {
		return createCollection(template);
	}

	public List<E> createCollection(Collection<? extends S> elements) {
		final List<E> result = getListImpl();
		if (elements != null) {
			for (S s : elements) {
				result.add(transform(s));
			}
		}
		return result;
	}
	
	protected abstract List<E> getListImpl();

}

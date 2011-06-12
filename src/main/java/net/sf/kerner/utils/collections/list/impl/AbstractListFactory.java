package net.sf.kerner.utils.collections.list.impl;

import java.util.List;


public abstract class AbstractListFactory<E> extends AbstractTransformingListFactory<E, E> {

	public AbstractListFactory() {
		super();
	}

	public AbstractListFactory(List<? extends E> template) {
		super(template);
	}
	
	public E transform(E element) {
		return element;
	}

}

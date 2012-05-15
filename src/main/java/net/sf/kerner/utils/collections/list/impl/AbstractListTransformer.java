package net.sf.kerner.utils.collections.list.impl;

import java.util.List;

import net.sf.kerner.utils.Transformer;
import net.sf.kerner.utils.collections.list.ListFactory;
import net.sf.kerner.utils.collections.list.TransformerList;

public abstract class AbstractListTransformer<T, V> extends ListWalkerDefault<T> implements
		Transformer<T, V>, TransformerList<T, V> {

	protected final ListFactory<V> factory;

	protected volatile List<V> result;
	
	protected volatile int currentIndex;

	public AbstractListTransformer(ListFactory<V> factory) {
		this.factory = factory;
		super.addVisitor(new DefaultListVisitorImpl<T>() {
			public Void visit(T element, int index) {
				setCurrentIndex(index);
				result.add(transform(element));
				return null;
			}
		});
	}

	public AbstractListTransformer() {
		this(new ArrayListFactory<V>());
	}

	@Override
	public synchronized void beforeWalk() {
		super.beforeWalk();
		result = factory.createCollection();
	}

	/**
	 * if {@code element == null}, empty list is returned.
	 */
	public synchronized List<V> transformCollection(List<? extends T> element) {
		if (element != null)
			walk(element);
		return result;
	}

	protected int getCurrentIndex() {
		return currentIndex;
	}

	private void setCurrentIndex(int currentIndex) {
		this.currentIndex = currentIndex;
	}

}

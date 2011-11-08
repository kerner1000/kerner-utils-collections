package net.sf.kerner.utils.collections.list;

import java.util.List;

import net.sf.kerner.utils.collections.list.impl.ArrayListFactory;
import net.sf.kerner.utils.collections.list.impl.DefaultListVisitorImpl;
import net.sf.kerner.utils.collections.list.impl.ListWalkerDefault;
import net.sf.kerner.utils.transformer.Transformer;

public abstract class AbstractListTransformer<T, V> extends ListWalkerDefault<T> implements
		Transformer<T, V>, ListTransformer<T, V> {

	protected final ListFactory<V> factory;

	protected volatile List<V> result;

	public AbstractListTransformer(ListFactory<V> factory) {
		super();
		this.factory = factory;
		super.addVisitor(new DefaultListVisitorImpl<T>() {
			public Void visit(T element) {
				result.add(transform(element));
				return null;
			}
		});
	}

	public AbstractListTransformer() {
		this(new ArrayListFactory<V>());
	}

	@Override
	public void beforeWalk() {
		super.beforeWalk();
		result = factory.createCollection();
	}

	/**
	 * if {@code element == null}, empty list is returned.
	 */
	public synchronized List<V> transformList(List<? extends T> element) {
		if (element != null)
			walk(element);
		return result;
	}

}

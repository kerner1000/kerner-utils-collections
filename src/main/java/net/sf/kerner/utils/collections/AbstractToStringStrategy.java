package net.sf.kerner.utils.collections;

public abstract class AbstractToStringStrategy<E> implements ToStringStrategy<E> {

	private final E e;

	public AbstractToStringStrategy(E e) {
		super();
		this.e = e;
	}

	@Override
	public String toString() {
		if (e == null)
			return "null";
		return visit(e);
	}

}

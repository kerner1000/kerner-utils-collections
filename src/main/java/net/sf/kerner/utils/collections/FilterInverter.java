package net.sf.kerner.utils.collections;

public class FilterInverter<E> implements Filter<E>{
	
	private final Filter<E> filter;
	
	public FilterInverter(Filter<E> filter) {
		super();
		this.filter = filter;
	}

	public Boolean visit(E element) {
		return !filter.visit(element);
	}

}

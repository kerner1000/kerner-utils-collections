package net.sf.kerner.utils.collections.list;

import net.sf.kerner.utils.collections.Filter;

public interface ListFilter<T> extends Filter<T>, ListVisitor<Boolean, T> {

}

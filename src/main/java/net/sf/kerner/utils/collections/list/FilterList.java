package net.sf.kerner.utils.collections.list;

import net.sf.kerner.utils.collections.Filter;

public interface FilterList<T> extends Filter<T>, VisitorList<Boolean, T> {

}

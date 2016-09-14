package net.sf.kerner.utils.collections;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import net.sf.kerner.utils.Cloneable;
import net.sf.kerner.utils.Cloner;
import net.sf.kerner.utils.collections.list.AbstractTransformingListFactory;

public class ClonerImpl<T extends Cloneable<T>> extends AbstractTransformingListFactory<T, T>
	implements Cloner<T>, ClonerList<T> {

    public T clone(final T element) {
	return element.clone();
    }

    public List<T> cloneList(final Collection<? extends T> elements) {
	return transformCollection(elements);
    }

    public Set<T> cloneSet(final Collection<? extends T> elements) {
	return new LinkedHashSet<T>(transformCollection(elements));
    }

    public T transform(final T element) {
	return clone(element);
    }

}

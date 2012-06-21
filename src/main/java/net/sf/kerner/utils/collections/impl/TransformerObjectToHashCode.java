package net.sf.kerner.utils.collections.impl;

import java.util.Collection;
import java.util.Set;

import net.sf.kerner.utils.collections.set.impl.FactoryLinkedHashSet;
import net.sf.kerner.utils.collections.set.impl.TransformerSet;

public class TransformerObjectToHashCode extends TransformerAbstract<Object, Integer> implements
        TransformerSet<Object, Integer> {

    public TransformerObjectToHashCode() {
        super(new FactoryLinkedHashSet<Integer>());
    }

    public Integer transform(final Object element) {
        return element.hashCode();
    }

    @Override
    public Set<Integer> transformCollection(final Collection<? extends Object> element) {
        return (Set<Integer>) super.transformCollection(element);
    }

}

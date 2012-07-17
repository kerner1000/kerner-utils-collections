package net.sf.kerner.utils.collections.list.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import net.sf.kerner.utils.Transformer;
import net.sf.kerner.utils.collections.list.FactoryList;
import net.sf.kerner.utils.collections.list.TransformerList;

public abstract class AbstractListTransformer<T, V> extends ListWalkerDefault<T> implements Transformer<T, V>,
        TransformerList<T, V> {

    protected final FactoryList<V> factory;

    protected volatile List<V> result;

    protected volatile int currentIndex;

    public AbstractListTransformer(final FactoryList<V> factory) {
        this.factory = factory;
        super.addVisitor(new DefaultListVisitorImpl<T>() {
            @Override
            public Void visit(final T element, final int index) {
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
    public synchronized List<V> transformCollection(final Collection<? extends T> element) {
        if (element != null)
            walk(new ArrayList<T>(element));
        return result;
    }

    protected int getCurrentIndex() {
        return currentIndex;
    }

    private void setCurrentIndex(final int currentIndex) {
        this.currentIndex = currentIndex;
    }

}

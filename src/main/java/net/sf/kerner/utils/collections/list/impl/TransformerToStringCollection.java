package net.sf.kerner.utils.collections.list.impl;

import java.util.Collection;
import java.util.List;

import net.sf.kerner.utils.transformer.TransformerToString;
import net.sf.kerner.utils.transformer.TransformerToStringDefault;

public class TransformerToStringCollection<T> extends AbstractTransformingListFactory<T, String> {

    private final TransformerToString<Object> DEFAULT_TRANSFORMER = new TransformerToStringDefault();

    private final TransformerToString<T> transformer;

    public TransformerToStringCollection() {
        this(null);
    }

    public TransformerToStringCollection(final TransformerToString<T> transformer) {
        this.transformer = transformer;
    }

    public String transform(final T arg0) {
        if (transformer == null) {
            return DEFAULT_TRANSFORMER.transform(arg0);
        }
        return transformer.transform(arg0);
    }

    @Override
    public List<String> transformCollection(final Collection<? extends T> element) {
        return super.transformCollection(element);
    }

}

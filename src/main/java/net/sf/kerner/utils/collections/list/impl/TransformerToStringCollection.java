package net.sf.kerner.utils.collections.list.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import net.sf.kerner.utils.TransformerToString;
import net.sf.kerner.utils.impl.TransformerToStringDefault;

public class TransformerToStringCollection extends AbstractTransformingListFactory<Object, String> {

    private final static TransformerToString DEFAULT_TRANSFORMER = new TransformerToStringDefault();

    private final TransformerToString transformer;

    public TransformerToStringCollection(TransformerToString transformer) {
        this.transformer = transformer;
    }

    public TransformerToStringCollection() {
        this(DEFAULT_TRANSFORMER);
    }

    public String transform(Object arg0) {
        return transformer.transform(arg0);
    }

    public synchronized List<String> transformCollection(Collection<? extends Object> element) {
        return super.transformCollection(new ArrayList<Object>(element));
    }

}

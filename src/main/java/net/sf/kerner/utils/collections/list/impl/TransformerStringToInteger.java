package net.sf.kerner.utils.collections.list.impl;

public class TransformerStringToInteger extends AbstractTransformingListFactory<String, Integer> {

    public Integer transform(final String element) {
        return Integer.parseInt(element);
    }

}

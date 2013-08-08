package net.sf.kerner.utils.collections.list.impl;

public class TransformerStringToDouble extends AbstractTransformingListFactory<String, Double> {

    public Double transform(final String element) {
        return Double.parseDouble(element);
    }

}

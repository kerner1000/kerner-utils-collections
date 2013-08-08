package net.sf.kerner.utils.collections.impl.transformer;

import net.sf.kerner.utils.ObjectPair;
import net.sf.kerner.utils.collections.list.impl.AbstractTransformingListFactory;

public class TransformerObjectPairToSecond<S> extends AbstractTransformingListFactory<ObjectPair<?, S>, S> {

    public S transform(final ObjectPair<?, S> element) {
        return element.getSecond();
    }

}

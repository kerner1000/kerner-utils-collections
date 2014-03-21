package net.sf.kerner.utils.collections.trasformer;

import net.sf.kerner.utils.collections.list.impl.AbstractTransformingListFactory;
import net.sf.kerner.utils.pair.ObjectPair;

public class TransformerObjectPairToSecond<S> extends AbstractTransformingListFactory<ObjectPair<?, S>, S> {

    public S transform(final ObjectPair<?, S> element) {
        return element.getSecond();
    }

}

package net.sf.kerner.utils.collections.trasformer;

import net.sf.kerner.utils.collections.list.impl.AbstractTransformingListFactory;
import net.sf.kerner.utils.pair.ObjectPair;

public class TransformerObjectPairToFirst<F> extends AbstractTransformingListFactory<ObjectPair<F, ?>, F> {

    public F transform(final ObjectPair<F, ?> element) {
        return element.getFirst();
    }

}

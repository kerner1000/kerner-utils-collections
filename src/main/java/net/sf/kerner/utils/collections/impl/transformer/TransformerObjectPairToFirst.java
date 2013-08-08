package net.sf.kerner.utils.collections.impl.transformer;

import net.sf.kerner.utils.ObjectPair;
import net.sf.kerner.utils.collections.list.impl.AbstractTransformingListFactory;

public class TransformerObjectPairToFirst<F> extends AbstractTransformingListFactory<ObjectPair<F, ?>, F> {

    public F transform(final ObjectPair<F, ?> element) {
        return element.getFirst();
    }

}

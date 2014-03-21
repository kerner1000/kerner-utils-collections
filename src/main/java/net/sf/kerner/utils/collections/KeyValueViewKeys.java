package net.sf.kerner.utils.collections;

import java.util.Collection;
import java.util.List;

import net.sf.kerner.utils.collections.list.FactoryList;
import net.sf.kerner.utils.collections.list.impl.ArrayListFactory;
import net.sf.kerner.utils.pair.KeyValue;
import net.sf.kerner.utils.transformer.ViewKeyValueKey;

public class KeyValueViewKeys<K> extends ViewKeyValueKey<K> implements TransformerCollection<KeyValue<K, ?>, K> {

    private final FactoryList<K> factory;

    public KeyValueViewKeys(FactoryList<K> factory) {
        this.factory = factory;
    }

    public KeyValueViewKeys() {
        this(new ArrayListFactory<K>());
    }

    public List<K> transformCollection(Collection<? extends KeyValue<K, ?>> element) {
        List<K> result = factory.createCollection();
        for (KeyValue<K, ?> e : element) {
            result.add(transform(e));
        }
        return result;
    }

}

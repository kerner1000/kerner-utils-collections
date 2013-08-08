package net.sf.kerner.utils.collections.map.collection.impl;

import java.util.Collection;
import java.util.Set;

import net.sf.kerner.utils.collections.map.FactoryMap;
import net.sf.kerner.utils.collections.map.collection.MapCollectionAbstract;

public class MapSetObject extends MapSet<Object, Object> {

    public MapSetObject() {

    }

    public MapSetObject(final FactoryMap<Object, Set<Object>> mapFactory) {
        super(mapFactory);

    }

    public MapSetObject(final FactoryMap<Object, Set<Object>> mapFactory,
            final MapCollectionAbstract<Object, Object, Set<Object>> template) {
        super(mapFactory, template);

    }

    public MapSetObject(final MapCollectionAbstract<Object, Object, Set<Object>> template) {
        super(template);

    }

    @SuppressWarnings("unchecked")
    @Override
    public void put(final Object key, final Object value) {
        if (value instanceof Collection) {
            putAll(key, (Collection<Object>) value);
        } else {
            super.put(key, value);
        }
    }

}

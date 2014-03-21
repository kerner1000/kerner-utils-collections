package net.sf.kerner.utils.collections.map.collection.impl;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import net.sf.kerner.utils.collections.map.collection.MapCollectionAbstract;

public class MapSetObject extends MapSet<Object, Object> {

    public MapSetObject() {

    }

    public MapSetObject(final Map<Object, Set<Object>> map) {
        super(map);

    }

    public MapSetObject(final Map<Object, Set<Object>> map,
            final MapCollectionAbstract<Object, Object, Set<Object>> template) {
        super(map, template);

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

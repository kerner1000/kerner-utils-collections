/**********************************************************************
Copyright (c) 2012 Alexander Kerner. All rights reserved.
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 ***********************************************************************/

package net.sf.kerner.utils.collections.map;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 
 * A {@code CollectionMap} represents a {@link Map}, that contains values, which
 * are itself a {@link Collection}.
 * 
 * <p>
 * <b>Example:</b><br>
 * 
 * </p>
 * <p>
 * 
 * <pre>
 * TODO example
 * </pre>
 * 
 * </p>
 * 
 * @author <a href="mailto:alex.kerner.24@googlemail.com">Alexander Kerner</a>
 * @version May 2, 2012
 * 
 * @param <K>
 *            type of keys in this map
 * @param <V>
 *            type of values in this map
 * @param <L>
 *            type of implementation of {@link Collection}
 */
public interface CollectionMap<K, V, L extends Collection<V>> {

    /**
     * 
     * Add another key value mapping to this {@code CollectionMap}. </p> If this
     * {@code CollectionMap} already contains this key, The value is added to
     * the {@code Collection} that is mapped by this key.</p> If the
     * {@code CollectionMap} does not contain this key, a new {@code Collection}
     * is created, which will be associated by given key and holds initially
     * given value.
     * 
     */
    void put(K k, V v);

    /**
     * 
     * Add all key value mappings to this {@code CollectionMap}. </p> If this
     * {@code CollectionMap} already contains this key, All values are added to
     * the {@code Collection} that is mapped by this key.
     * 
     */
    void putAll(K k, Collection<? extends V> values);

    /**
     * 
     * Add all key value mappings to this {@code CollectionMap}. </p> If this
     * {@code CollectionMap} already contains any of given keys, All values are
     * added to the {@code Collection} that are mapped by this key.
     * 
     */
    void putAll(Map<? extends K, ? extends V> values);

    /**
     * 
     * Add all key value mappings to this {@code CollectionMap}. </p> If this
     * {@code CollectionMap} already contains any of given keys, All values are
     * added to the {@code Collection} that are mapped by this key.
     * 
     */
    void putAll(CollectionMap<? extends K, ? extends V, L> values);

    int size();

    int size(K k);

    boolean isEmpty();

    boolean isEmpty(K k);

    boolean containsKey(K k);

    boolean containsValue(V v);

    L get(K k);

    void remove(K k);

    void removeValue(V v);

    void clear();

    Set<K> keySet();

    L values();

    Set<Entry<K, L>> entrySet();
}

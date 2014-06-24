/*******************************************************************************
 * Copyright (c) 2010-2014 Alexander Kerner. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package net.sf.kerner.utils.collections;

import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class PropertiesSorted implements SortedMap<Object, Object>, Serializable {

    private static final long serialVersionUID = -7867760517665815796L;

    private final SortedMap<Object, Object> delegate;

    public PropertiesSorted() {
        delegate = new TreeMap<Object, Object>();
    }

    public PropertiesSorted(final Comparator<? super Object> c) {
        delegate = new TreeMap<Object, Object>(c);
    }

    public PropertiesSorted(final SortedMap<Object, Object> delegate) {
        this.delegate = delegate;
    }

    public void clear() {
        delegate.clear();
    }

    public Comparator<? super Object> comparator() {
        return delegate.comparator();
    }

    public boolean containsKey(final Object key) {
        return delegate.containsKey(key);
    }

    public boolean containsValue(final Object value) {
        return delegate.containsValue(value);
    }

    public Set<java.util.Map.Entry<Object, Object>> entrySet() {
        return delegate.entrySet();
    }

    @Override
    public boolean equals(final Object o) {
        return delegate.equals(o);
    }

    public Object firstKey() {
        return delegate.firstKey();
    }

    public Object get(final Object key) {
        return delegate.get(key);
    }

    public synchronized String getString(final Object key) {
        final Object result = delegate.get(key);
        if (result != null) {
            return result.toString();
        }
        return null;
    }

    @Override
    public int hashCode() {
        return delegate.hashCode();
    }

    public SortedMap<Object, Object> headMap(final Object toKey) {
        return delegate.headMap(toKey);
    }

    public boolean isEmpty() {
        return delegate.isEmpty();
    }

    public Set<Object> keySet() {
        return delegate.keySet();
    }

    public Object lastKey() {
        return delegate.lastKey();
    }

    public Object put(final Object key, final Object value) {
        return delegate.put(key, value);
    }

    public void putAll(final Map<? extends Object, ? extends Object> m) {
        delegate.putAll(m);
    }

    public synchronized void putAll(final Properties p) {
        for (final java.util.Map.Entry<Object, Object> e : p.entrySet()) {
            put(e.getKey(), e.getValue());
        }
    }

    public Object remove(final Object key) {
        return delegate.remove(key);
    }

    public int size() {
        return delegate.size();
    }

    public SortedMap<Object, Object> subMap(final Object fromKey, final Object toKey) {
        return delegate.subMap(fromKey, toKey);
    }

    public SortedMap<Object, Object> tailMap(final Object fromKey) {
        return delegate.tailMap(fromKey);
    }

    public Properties toProperties() {
        final Properties p = new Properties();
        p.putAll(delegate);
        return p;
    }

    @Override
    public String toString() {
        return UtilCollection.toString(delegate.entrySet());
    }

    public Collection<Object> values() {
        return delegate.values();
    }
}

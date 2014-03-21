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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

/**
 * An instance of {@link Properties} that keeps properties sorted by string representation of keys.
 * <p>
 * <b>Example:</b><br>
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
 * @version 2011-10-27
 */
public class PropertiesSorted extends Properties {

    private static final long serialVersionUID = -3190096405009723488L;

    private final static IteratorToEnumerationTransformer<Object> t = new IteratorToEnumerationTransformer<Object>();

    public PropertiesSorted() {

    }

    public PropertiesSorted(final Properties defaults) {
        super(defaults);
    }

    @Override
    public synchronized Enumeration<Object> keys() {
        return t.transform(keySet().iterator());
    }

    @Override
    public synchronized Set<Object> keySet() {
        final Set<Object> keys = super.keySet();
        final List<Object> keyList = new ArrayList<Object>(keys);
        Collections.sort(keyList, new Comparator<Object>() {
            public int compare(final Object o1, final Object o2) {
                return o1.toString().compareToIgnoreCase(o2.toString());
            }
        });
        return new LinkedHashSet<Object>(keyList);
    }

    @Override
    public synchronized String toString() {
        final StringBuilder sb = new StringBuilder();
        final Iterator<Object> it = keySet().iterator();
        while (it.hasNext()) {
            final Object k = it.next();
            final Object v = get(k);
            sb.append(k);
            sb.append("=");
            sb.append(v);
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

}

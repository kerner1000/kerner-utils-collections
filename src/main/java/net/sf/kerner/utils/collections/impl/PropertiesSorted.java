/**********************************************************************
Copyright (c) 2009-2011 Alexander Kerner. All rights reserved.
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

package net.sf.kerner.utils.collections.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

/**
 * 
 * An instance of {@link Properties} that keeps properties sorted by string
 * representation of keys.
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
 * @version 2011-10-27
 * 
 */
public class PropertiesSorted extends Properties {

	private static final long serialVersionUID = -3190096405009723488L;

	private final static IteratorToEnumerationTransformer<Object> t = new IteratorToEnumerationTransformer<Object>();

	@Override
	public synchronized Enumeration<Object> keys() {
		return t.transform(keySet().iterator());
	}

	@Override
	public synchronized Set<Object> keySet() {
		Set<Object> keys = super.keySet();
		List<Object> keyList = new ArrayList<Object>(keys);
		Collections.sort(keyList, new Comparator<Object>() {
			public int compare(Object o1, Object o2) {
				return o1.toString().compareToIgnoreCase(o2.toString());
			}
		});
		return new LinkedHashSet<Object>(keyList);
	}

}

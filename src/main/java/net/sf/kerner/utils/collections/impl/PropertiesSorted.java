package net.sf.kerner.utils.collections.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

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

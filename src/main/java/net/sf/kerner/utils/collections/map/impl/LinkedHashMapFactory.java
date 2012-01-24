package net.sf.kerner.utils.collections.map.impl;

import java.util.LinkedHashMap;
import java.util.Map;

import net.sf.kerner.utils.collections.map.MapFactory;

public class LinkedHashMapFactory<K, V> implements MapFactory<K, V>{

	public Map<K, V> create() {
		return new LinkedHashMap<K,V>();
	}

}

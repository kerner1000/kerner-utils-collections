package net.sf.kerner.utils.collections.map.impl;

import java.util.Map;
import java.util.TreeMap;

import net.sf.kerner.utils.collections.map.MapFactory;

public class TreeMapFactory<K, V> implements MapFactory<K, V> {

	public Map<K, V> create() {
		return new TreeMap<K, V>();
	}

}

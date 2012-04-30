package net.sf.kerner.utils.collections.map.impl;

import java.util.Map;
import java.util.TreeMap;

import net.sf.kerner.utils.collections.map.FactoryMap;

public class TreeMapFactory<K, V> implements FactoryMap<K, V> {

	public Map<K, V> create() {
		return new TreeMap<K, V>();
	}

}

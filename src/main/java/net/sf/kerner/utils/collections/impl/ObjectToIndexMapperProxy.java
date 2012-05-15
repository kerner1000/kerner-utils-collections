package net.sf.kerner.utils.collections.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class ObjectToIndexMapperProxy<T> extends ObjectToIndexMapperImpl<T> {

	protected Map<T, Object> identToIdent;

	public ObjectToIndexMapperProxy(Map<T, Object> identToIdent) {
		super(new ArrayList<T>(identToIdent.keySet()));
		this.identToIdent = new LinkedHashMap<T, Object>(identToIdent);
	}

	public int get(T key) {
		List<T> keySet = new ArrayList<T>(identToIdent.keySet());
		for (int i = 0; i < keySet.size(); i++) {
			if (keySet.get(i) != null && keySet.get(i).equals(key)) {
				return i;
			}
		}
		throw new NoSuchElementException();
	}

	public Object getValue(int index) {
		Object o = super.getValue(index);
		for (Object oo : identToIdent.values()) {
			if (o.equals(oo)) {
				return oo;
			}
		}
		throw new NoSuchElementException();
	}

	public boolean containsKey(T key) {
		return identToIdent.containsKey(key);
	}

	public boolean containsValue(int index) {
		return identToIdent.containsValue(super.getValue(index));
	}

	public List<T> keys() {
		return new ArrayList<T>(identToIdent.keySet());
	}

	public void addMapping(T key) {
		throw new IllegalStateException();
	}

	public void addMapping(T key, int index) {
		throw new IllegalStateException();
	}
}

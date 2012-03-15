package net.sf.kerner.utils.collections.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class ObjectToIndexMapperProxy extends ObjectToIndexMapperImpl {
	
	protected Map<Object, Object> identToIdent;
	
	public ObjectToIndexMapperProxy(Map<Object, Object> identToIdent) {
		super(identToIdent.values());
		this.identToIdent = new LinkedHashMap<Object, Object>(identToIdent);
	}

	public int get(Object key) {
		if(super.containsKey(identToIdent.get(key))){
		return super.get(identToIdent.get(key));
		}
		List<Object> keySet = new ArrayList<Object>(identToIdent.keySet());
		for(int i = 0; i < keySet.size(); i++){
			if(keySet.get(i) != null && keySet.get(i).equals(key)){
				return i;
			}
		}
		throw new NoSuchElementException();
	}
	
	public Object getValue(int index) {
		Object o = super.getValue(index);
		for(Object oo : identToIdent.values()){
			if(o.equals(oo)){
				return oo;
			}
		}
		throw new NoSuchElementException();
	}

	public boolean containsKey(Object key) {
		return identToIdent.containsKey(key);
	}

	public boolean containsValue(int index) {
		return identToIdent.containsValue(super.getValue(index));
	}

	public List<Object> keys() {
		return new ArrayList<Object>(identToIdent.keySet());
	}
	
	public void addMapping(Object key) {
		throw new IllegalStateException();	
	}

	public void addMapping(Object key, int index) {
		throw new IllegalStateException();
	}
	
	

}

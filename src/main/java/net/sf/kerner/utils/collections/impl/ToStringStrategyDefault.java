package net.sf.kerner.utils.collections.impl;

import net.sf.kerner.utils.collections.ToStringStrategy;

public class ToStringStrategyDefault implements ToStringStrategy<Object> {

	public static final String NULL_STRING = "null";
	
	public String transform(Object element) {
		if(element == null){
			return NULL_STRING;
		}
		return element.toString();
	}

}

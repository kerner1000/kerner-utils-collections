package net.sf.kerner.utils.collections;

import java.util.Collection;
import java.util.Comparator;

public class CollectionUtils {
	
	private CollectionUtils(){}
	
	public static <T> T getHighest(Collection<? extends T> elements, Comparator<T> c){
		T result = null;
		
		for(T e : elements){
			if(result == null){
				result = e;
			} else {
				int i = c.compare(e, result);
				if(i > 0)
					result = e;
			}
		}
		
		return result;
	}
	
	public static <T> T getLowest(Collection<? extends T> elements, Comparator<T> c){
		T result = null;
		
		for(T e : elements){
			if(result == null){
				result = e;
			} else {
				int i = c.compare(e, result);
				if(i < 0)
					result = e;
			}
		}
		
		return result;
	}

}

package net.sf.kerner.utils.collections;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

import net.sf.kerner.utils.StringUtils;

public class CollectionUtils {

	private CollectionUtils() {
	}
	
	public static String toString(Iterable<?> elements){
		final StringBuilder b = new StringBuilder();
		b.append(StringUtils.NEW_LINE_STRING);
		final Iterator<?> i = elements.iterator();
		while(i.hasNext()){
			b.append(i.next());
			if(i.hasNext())
				b.append(StringUtils.NEW_LINE_STRING);
		}
		return b.toString();
	}
	
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

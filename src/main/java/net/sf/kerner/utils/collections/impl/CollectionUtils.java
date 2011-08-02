package net.sf.kerner.utils.collections.impl;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

import net.sf.kerner.utils.StringUtils;
import net.sf.kerner.utils.collections.CollectionFactory;
import net.sf.kerner.utils.collections.list.impl.ArrayListFactory;

public class CollectionUtils {

	private CollectionUtils() {
	}
	
	public static <C> Collection<C> append(Collection<? extends C> c1, Collection<? extends C> c2, CollectionFactory<C> factory){
		final Collection<C> result = factory.createCollection();
		result.addAll(c1);
		result.addAll(c2);
		return result;
	}
	
	public static <C> Collection<C> append(Collection<? extends C> c1, Collection<? extends C> c2){
		return append(c1, c2, new ArrayListFactory<C>());
	}
	
	public static String toString(Iterable<?> elements){
		if(!elements.iterator().hasNext())
			return "";
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

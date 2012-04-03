package net.sf.kerner.utils.collections.impl;

import net.sf.kerner.utils.collections.ObjectIdentifier;

public class ObjectIdentifierProto<T extends Enum<T>> implements ObjectIdentifier<T> {
	
	protected final T identifier;

	public ObjectIdentifierProto(T identifier) {
		this.identifier = identifier;
	}
	
	public T getIdentifier() {
		return identifier;
	}

}

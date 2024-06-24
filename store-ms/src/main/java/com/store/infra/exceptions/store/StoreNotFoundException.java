package com.store.infra.exceptions.store;

public class StoreNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -1539901316338050306L;

	public StoreNotFoundException(String msg) {
		super(msg);
	}

}

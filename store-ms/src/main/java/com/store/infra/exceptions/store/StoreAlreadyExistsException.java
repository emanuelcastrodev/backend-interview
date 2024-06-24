package com.store.infra.exceptions.store;

public class StoreAlreadyExistsException extends RuntimeException {
	private static final long serialVersionUID = -8989474267770821853L;

	public StoreAlreadyExistsException(String msg) {
		super(msg);
	}

}

package com.store.infra.exceptions.car;

public class CarNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -7364384670069140405L;

	public CarNotFoundException(String msg) {
		super(msg);
	}

}
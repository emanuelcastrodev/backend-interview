package com.store.infra.exceptions.opportunity;

public class OpportunityUpdateException extends RuntimeException {
	private static final long serialVersionUID = 8630577536529903233L;

	public OpportunityUpdateException(String msg) {
		super(msg);
	}

}

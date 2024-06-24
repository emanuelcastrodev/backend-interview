package com.store.infra.exceptions.opportunity;

public class OpportunityNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -7364384670069140405L;

	public OpportunityNotFoundException(String msg) {
		super(msg);
	}

}

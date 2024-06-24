package com.store.enums;

public enum OpportunityStatus {
	NEW(0), IN_SERVICE(1), CLOSED(2);

	private Integer value;

	OpportunityStatus(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public OpportunityStatus getOpportunityStatus(Integer value) {
		for (OpportunityStatus status : OpportunityStatus.values()) {
			if (status.getValue().equals(value))
				return status;
		}
		throw new RuntimeException(String.format("ID: %s not valid for OpportunityStatus", value));
	}
}

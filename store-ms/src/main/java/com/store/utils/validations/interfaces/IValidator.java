package com.store.utils.validations.interfaces;

public interface IValidator {

	default void validateNext() {
		IValidator nextValidator = getNextValidator();
		if (nextValidator != null)
			nextValidator.validate();
	}

	IValidator getNextValidator();

	void validate();
}

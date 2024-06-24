package com.store.utils.validations.abstracts;

import com.store.utils.validations.interfaces.IValidator;

public abstract class AbstractChainValidator implements IValidator {

	private IValidator nextValidator;

	public AbstractChainValidator(IValidator nextValidator) {
		this.nextValidator = nextValidator;
	}

	@Override
	public IValidator getNextValidator() {
		return nextValidator;
	}

	@Override
	public void validate() {
		validateNext();
	}

}

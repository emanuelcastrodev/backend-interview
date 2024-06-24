package com.store.utils.validations;

import com.store.infra.exceptions.store.StoreAlreadyExistsException;
import com.store.repositories.StoreRepository;
import com.store.utils.validations.abstracts.AbstractChainValidator;
import com.store.utils.validations.interfaces.IValidator;

public class CNPJExistsValidator extends AbstractChainValidator {

	private StoreRepository rep;
	private String cnpj;

	public CNPJExistsValidator(IValidator nextValidator, StoreRepository rep, String cnpj) {
		super(nextValidator);
		this.rep = rep;
		this.cnpj = cnpj;
	}

	@Override
	public void validate() {
		if (rep.findByCnpj(cnpj).isPresent())
			throw new StoreAlreadyExistsException(String.format("Store with cnpj(%s) already exists.", cnpj));
		super.validate();
	}

}

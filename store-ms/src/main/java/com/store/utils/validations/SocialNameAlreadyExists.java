package com.store.utils.validations;

import com.store.infra.exceptions.store.StoreAlreadyExistsException;
import com.store.repositories.StoreRepository;
import com.store.utils.validations.abstracts.AbstractChainValidator;
import com.store.utils.validations.interfaces.IValidator;

public class SocialNameAlreadyExists extends AbstractChainValidator {

	private StoreRepository rep;
	private String socialName;

	public SocialNameAlreadyExists(IValidator nextValidator, StoreRepository rep, String socialName) {
		super(nextValidator);
		this.rep = rep;
		this.socialName = socialName;
	}

	@Override
	public void validate() {
		if (rep.findBySocialName(socialName).isPresent())
			throw new StoreAlreadyExistsException(
					String.format("Store with Social Name(%s) already exists.", socialName));
		super.validate();
	}

}

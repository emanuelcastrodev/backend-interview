package com.store.mappers.v2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.store.dtos.v2.store.ResponseStoreDTOWithHateos;
import com.store.entities.Store;
import com.store.mappers.v1.OpportunityMapperImpl;
import com.store.mappers.v2.interfaces.StoreMapperWithHateos;

@Component
public class StoreMapperImplV2 implements StoreMapperWithHateos {

	@Autowired
	OpportunityMapperImpl opportunityMapper;

	@Override
	public ResponseStoreDTOWithHateos toDTOWithHateos(Store store) {
		return new ResponseStoreDTOWithHateos(store.getUuid(), store.getCnpj(), store.getSocialName(),
				opportunityMapper.toDTO(store.getOpportunities()));
	}

}

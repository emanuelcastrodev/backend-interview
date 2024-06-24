package com.store.services.v2;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.controllers.v1.store.StoreController;
import com.store.dtos.v1.store.CreateStoreRequestDTO;
import com.store.dtos.v2.store.ResponseStoreDTOWithHateos;
import com.store.entities.Store;
import com.store.mappers.v2.StoreMapperImplV2;
import com.store.repositories.StoreRepository;
import com.store.services.v1.StoreServiceImpl;
import com.store.services.v2.interfaces.StoreServiceWithHateos;

@Service
public class StoreServiceImplWithHateos implements StoreServiceWithHateos {

	@Autowired
	StoreRepository rep;

	@Autowired
	StoreServiceImpl storeServiceV1;

	@Autowired
	StoreMapperImplV2 storeMapper;

	@Override
	public ResponseStoreDTOWithHateos create(CreateStoreRequestDTO dto) {
		Store store = storeServiceV1.createStoreAndReturnEntity(dto);
		ResponseStoreDTOWithHateos responseHateos = storeMapper.toDTOWithHateos(store);
		responseHateos.add(linkTo(methodOn(StoreController.class).findByUuid(responseHateos.getUuid())).withSelfRel());
		return responseHateos;
	}

}

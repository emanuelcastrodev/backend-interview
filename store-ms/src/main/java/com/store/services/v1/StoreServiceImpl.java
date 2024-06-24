package com.store.services.v1;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.store.dtos.v1.store.CreateStoreRequestDTO;
import com.store.dtos.v1.store.ResponseStoreDTO;
import com.store.entities.Store;
import com.store.infra.exceptions.store.StoreNotFoundException;
import com.store.mappers.v1.StoreMapperImpl;
import com.store.repositories.StoreRepository;
import com.store.services.v1.interfaces.StoreService;
import com.store.utils.validations.CNPJExistsValidator;
import com.store.utils.validations.SocialNameAlreadyExists;

@Service
public class StoreServiceImpl implements StoreService {

	@Autowired
	StoreRepository rep;

	@Autowired
	StoreMapperImpl storeMapper;

	@Override
	public ResponseStoreDTO findByUUID(UUID uuid) {
		return storeMapper.toDTO(getStoreByUUID(uuid));
	}

	@Override
	public void createStore(CreateStoreRequestDTO dto) {
		createStoreAndReturn(dto);
	}

	@Override
	public Store getStoreByUUID(UUID uuid) {
		return rep.findByUuid(uuid)
				.orElseThrow(() -> new StoreNotFoundException(String.format("Store with uuid (%s) not found.", uuid)));
	}

	public Store save(Store store) {
		return rep.save(store);
	}

	@Override
	public Page<ResponseStoreDTO> findAll(Pageable pageable) {
		return storeMapper.toDTO(rep.findAll(pageable));
	}

	@Override
	public Store createStoreAndReturnEntity(CreateStoreRequestDTO dto) {
		return createStoreAndReturn(dto);
	}

	private Store createStoreAndReturn(CreateStoreRequestDTO dto) {
		Store store = storeMapper.toEntity(dto);
		new CNPJExistsValidator(new SocialNameAlreadyExists(null, rep, store.getSocialName()), rep, store.getCnpj())
				.validate();
		return save(store);
	}

}

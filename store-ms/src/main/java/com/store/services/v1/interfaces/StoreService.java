package com.store.services.v1.interfaces;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.store.dtos.v1.store.CreateStoreRequestDTO;
import com.store.dtos.v1.store.ResponseStoreDTO;
import com.store.entities.Store;

public interface StoreService {

	ResponseStoreDTO findByUUID(UUID uuid);

	Store getStoreByUUID(UUID uuid);

	void createStore(CreateStoreRequestDTO dto);

	Store createStoreAndReturnEntity(CreateStoreRequestDTO dto);

	Page<ResponseStoreDTO> findAll(Pageable pageable);
}

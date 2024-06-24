package com.store.mappers.v1.interfaces;

import org.springframework.data.domain.Page;

import com.store.dtos.v1.store.CreateStoreRequestDTO;
import com.store.dtos.v1.store.ResponseStoreDTO;
import com.store.entities.Store;

public interface StoreMapper {

	ResponseStoreDTO toDTO(Store store);

	Store toEntity(CreateStoreRequestDTO dto);

	Page<ResponseStoreDTO> toDTO(Page<Store> storePageable);
}

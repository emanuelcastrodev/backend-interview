package com.store.mappers.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.store.dtos.v1.store.CreateStoreRequestDTO;
import com.store.dtos.v1.store.ResponseStoreDTO;
import com.store.entities.Store;
import com.store.mappers.v1.interfaces.StoreMapper;

@Component
public class StoreMapperImpl implements StoreMapper {

	@Autowired
	OpportunityMapperImpl opportunityMapper;

	@Override
	public ResponseStoreDTO toDTO(Store store) {
		ResponseStoreDTO responseStoreDTO = new ResponseStoreDTO(store.getUuid(), store.getCnpj(),
				store.getSocialName(), opportunityMapper.toDTO(store.getOpportunities()));
		return responseStoreDTO;
	}

	@Override
	public Store toEntity(CreateStoreRequestDTO dto) {
		return Store.Builder.of(dto.cnpj(), dto.socialName()).build();

	}

	@Override
	public Page<ResponseStoreDTO> toDTO(Page<Store> storePageable) {
		return storePageable.map(store -> toDTO(store));
	}

}

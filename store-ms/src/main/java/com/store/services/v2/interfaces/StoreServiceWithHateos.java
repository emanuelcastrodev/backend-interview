package com.store.services.v2.interfaces;

import com.store.dtos.v1.store.CreateStoreRequestDTO;
import com.store.dtos.v2.store.ResponseStoreDTOWithHateos;

public interface StoreServiceWithHateos {

	ResponseStoreDTOWithHateos create(CreateStoreRequestDTO dto);

}

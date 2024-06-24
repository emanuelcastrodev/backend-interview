package com.store.mappers.v2.interfaces;

import com.store.dtos.v2.store.ResponseStoreDTOWithHateos;
import com.store.entities.Store;

public interface StoreMapperWithHateos {

	ResponseStoreDTOWithHateos toDTOWithHateos(Store store);
}

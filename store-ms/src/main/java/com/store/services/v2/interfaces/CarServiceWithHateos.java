package com.store.services.v2.interfaces;

import com.store.dtos.v1.car.CreateCarRequestDTO;
import com.store.dtos.v2.car.ResponseCarDTOWithHeateos;

public interface CarServiceWithHateos {

	ResponseCarDTOWithHeateos create(CreateCarRequestDTO dto);

}

package com.store.mappers.v2.interfaces;

import com.store.dtos.v2.car.ResponseCarDTOWithHeateos;
import com.store.entities.Car;

public interface CarMapperWithHateos {

	ResponseCarDTOWithHeateos toDTOWithHateos(Car car);
}

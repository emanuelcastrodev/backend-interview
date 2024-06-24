package com.store.mappers.v1.interfaces;

import org.springframework.data.domain.Page;

import com.store.dtos.v1.car.CreateCarRequestDTO;
import com.store.dtos.v1.car.ResponseCarDTO;
import com.store.entities.Car;

public interface CarMapper {

	ResponseCarDTO toDTO(Car car);

	Car toEntity(CreateCarRequestDTO dto);

	Page<ResponseCarDTO> toDTO(Page<Car> carsPageable);
}

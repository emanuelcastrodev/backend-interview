package com.store.services.v1.interfaces;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.store.dtos.v1.car.CreateCarRequestDTO;
import com.store.dtos.v1.car.ResponseCarDTO;
import com.store.entities.Car;

public interface CarService {

	ResponseCarDTO findByUUID(UUID uuid);

	Car getCarByUUID(UUID uuid);

	void createCar(CreateCarRequestDTO dto);

	Car createCarAndReturnEntity(CreateCarRequestDTO dto);

	Page<ResponseCarDTO> findAll(Pageable pageable);
}

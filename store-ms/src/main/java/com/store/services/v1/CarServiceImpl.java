package com.store.services.v1;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.store.dtos.v1.car.CreateCarRequestDTO;
import com.store.dtos.v1.car.ResponseCarDTO;
import com.store.entities.Car;
import com.store.infra.exceptions.car.CarNotFoundException;
import com.store.mappers.v1.CarMapperImpl;
import com.store.repositories.CarRepository;
import com.store.services.v1.interfaces.CarService;

@Service
public class CarServiceImpl implements CarService {

	@Autowired
	CarRepository rep;

	@Autowired
	CarMapperImpl carMapper;

	@Override
	public ResponseCarDTO findByUUID(UUID uuid) {
		return carMapper.toDTO(getCarByUUID(uuid));
	}

	@Override
	public Car getCarByUUID(UUID uuid) {
		return rep.findByUuid(uuid)
				.orElseThrow(() -> new CarNotFoundException(String.format("Car with UUID(%s) not found.", uuid)));
	}

	@Override
	public void createCar(CreateCarRequestDTO dto) {
		createCarAndReturn(dto);
	}

	public Car save(Car car) {
		return rep.save(car);
	}

	@Override
	public Page<ResponseCarDTO> findAll(Pageable pageable) {
		return carMapper.toDTO(rep.findAll(pageable));
	}

	@Override
	public Car createCarAndReturnEntity(CreateCarRequestDTO dto) {
		return createCarAndReturn(dto);
	}

	private Car createCarAndReturn(CreateCarRequestDTO dto) {
		return save(carMapper.toEntity(dto));
	}

}

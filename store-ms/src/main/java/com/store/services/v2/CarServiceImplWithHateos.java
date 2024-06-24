package com.store.services.v2;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.controllers.v1.car.CarController;
import com.store.dtos.v1.car.CreateCarRequestDTO;
import com.store.dtos.v2.car.ResponseCarDTOWithHeateos;
import com.store.entities.Car;
import com.store.mappers.v2.CarMapperImpV2;
import com.store.repositories.StoreRepository;
import com.store.services.v1.CarServiceImpl;
import com.store.services.v2.interfaces.CarServiceWithHateos;

@Service
public class CarServiceImplWithHateos implements CarServiceWithHateos {

	@Autowired
	StoreRepository rep;

	@Autowired
	CarServiceImpl carServiceV1;

	@Autowired
	CarMapperImpV2 carMapper;

	@Override
	public ResponseCarDTOWithHeateos create(CreateCarRequestDTO dto) {
		Car car = carServiceV1.createCarAndReturnEntity(dto);
		ResponseCarDTOWithHeateos responseHateos = carMapper.toDTOWithHateos(car);
		responseHateos.add(linkTo(methodOn(CarController.class).findByUuid(responseHateos.getUuid())).withSelfRel());
		return responseHateos;
	}

}

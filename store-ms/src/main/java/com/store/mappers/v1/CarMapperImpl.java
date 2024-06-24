package com.store.mappers.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.store.dtos.v1.car.CreateCarRequestDTO;
import com.store.dtos.v1.car.ResponseCarDTO;
import com.store.entities.Car;
import com.store.mappers.v1.interfaces.CarMapper;

@Component
public class CarMapperImpl implements CarMapper {

	@Autowired
	OpportunityMapperImpl opportunityMapper;

	@Override
	public ResponseCarDTO toDTO(Car car) {
		return new ResponseCarDTO(car.getUuid(), car.getBrand(), car.getVersion(), car.getModelYear(),
				opportunityMapper.toDTO(car.getOpportunities()));
	}

	@Override
	public Car toEntity(CreateCarRequestDTO dto) {
		return Car.Builder.of(dto.brand()).setVersion(dto.version()).setModelYear(dto.modelYear()).build();
	}

	@Override
	public Page<ResponseCarDTO> toDTO(Page<Car> carsPageable) {
		return carsPageable.map(car -> toDTO(car));
	}

}

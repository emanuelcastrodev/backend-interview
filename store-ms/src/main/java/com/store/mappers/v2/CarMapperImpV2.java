package com.store.mappers.v2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.store.dtos.v2.car.ResponseCarDTOWithHeateos;
import com.store.entities.Car;
import com.store.mappers.v1.OpportunityMapperImpl;
import com.store.mappers.v2.interfaces.CarMapperWithHateos;

@Component
public class CarMapperImpV2 implements CarMapperWithHateos {

	@Autowired
	OpportunityMapperImpl opportunityMapper;

	@Override
	public ResponseCarDTOWithHeateos toDTOWithHateos(Car car) {
		return new ResponseCarDTOWithHeateos(car.getUuid(), car.getBrand(), car.getVersion(), car.getModelYear(),
				opportunityMapper.toDTO(car.getOpportunities()));
	}

}

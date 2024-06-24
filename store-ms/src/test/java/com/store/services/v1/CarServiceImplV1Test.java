package com.store.services.v1;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.store.dtos.v1.car.CreateCarRequestDTO;
import com.store.entities.Car;
import com.store.mappers.v1.CarMapperImpl;
import com.store.repositories.CarRepository;

@DataJpaTest
@ExtendWith(MockitoExtension.class)
class CarServiceImplV1Test {

	@Mock
	CarRepository rep;

	@Mock
	CarMapperImpl mapper;

	@InjectMocks
	private CarServiceImpl service;

	private CreateCarRequestDTO createDTO;

	private Car returnedCar;

	@BeforeEach
	public void setup() {
		createDTO = new CreateCarRequestDTO("Ford", "5ad", 2010);
		returnedCar = Car.Builder.of("Ford").setVersion("5ad").setModelYear(2010).setId(1L).build();
	}

	@DisplayName("JUnit Test for return object in save Car method")
	@Test
	void testGivenCarObject_WhenSaveCar_thentReturnCarObject() {
		given(service.createCarAndReturnEntity(null)).willReturn(returnedCar);

		Car car = service.createCarAndReturnEntity(createDTO);
		assertNotNull(car);
		assertTrue(car.getBrand().equals(returnedCar.getBrand()));
		assertTrue(car.getId().equals(returnedCar.getId()));
		assertTrue(car.getModelYear().equals(returnedCar.getModelYear()));
		assertTrue(car.getVersion().equals(returnedCar.getVersion()));
	}
}

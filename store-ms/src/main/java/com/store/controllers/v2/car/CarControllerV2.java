package com.store.controllers.v2.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.dtos.v1.car.CreateCarRequestDTO;
import com.store.dtos.v2.car.ResponseCarDTOWithHeateos;
import com.store.services.v2.CarServiceImplWithHateos;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/car/v2")
@SecurityRequirement(name = "security_auth")
public class CarControllerV2 {

	@Autowired
	CarServiceImplWithHateos service;

	@PostMapping("/create")
	public ResponseEntity<ResponseCarDTOWithHeateos> createOpportunity(@RequestBody CreateCarRequestDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
	}
}

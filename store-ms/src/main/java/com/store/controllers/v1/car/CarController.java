package com.store.controllers.v1.car;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.dtos.v1.car.CreateCarRequestDTO;
import com.store.dtos.v1.car.ResponseCarDTO;
import com.store.dtos.v1.exceptions.ResponseExceptionDTO;
import com.store.services.v1.CarServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/car/v1")
@SecurityRequirement(name = "security_auth")
public class CarController {

	@Autowired
	CarServiceImpl service;

	@GetMapping("/{uuid}")
	@Operation(summary = "Find Car", description = "Find Car by UUID", responses = {
			@ApiResponse(description = "Success", responseCode = "200", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseCarDTO.class)) }),
			@ApiResponse(description = "Not Found", responseCode = "400", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseExceptionDTO.class)) }) })
	public ResponseEntity<ResponseCarDTO> findByUuid(
			@Parameter(name = "uuid", example = "7e2c0193-9aaf-4838-b957-d5241c0c921c", description = "Car UUID") @PathVariable UUID uuid) {
		return ResponseEntity.ok(service.findByUUID(uuid));
	}

	@GetMapping("/all")
	@Operation(summary = "Find All Cars")
	public ResponseEntity<Page<ResponseCarDTO>> findAll(Pageable pageable) {
		return ResponseEntity.ok(service.findAll(pageable));
	}

	@PostMapping("/create")
	public ResponseEntity<Void> createOpportunity(@RequestBody CreateCarRequestDTO dto) {
		service.createCar(dto);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}

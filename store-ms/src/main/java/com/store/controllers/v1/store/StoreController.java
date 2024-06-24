package com.store.controllers.v1.store;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.dtos.v1.exceptions.ResponseExceptionDTO;
import com.store.dtos.v1.store.CreateStoreRequestDTO;
import com.store.dtos.v1.store.ResponseStoreDTO;
import com.store.services.v1.StoreServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/store/v1")
@SecurityRequirement(name = "security_auth")
public class StoreController {

	@Autowired
	StoreServiceImpl service;

	@GetMapping("/{uuid}")
	@Operation(summary = "Find Store", description = "Find Store by UUID", responses = {
			@ApiResponse(description = "Success", responseCode = "200", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseStoreDTO.class)) }),
			@ApiResponse(description = "Not Found", responseCode = "400", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseExceptionDTO.class)) }) })
	public ResponseEntity<ResponseStoreDTO> findByUuid(
			@Parameter(name = "uuid", example = "7e2c0193-9aaf-4838-b957-d5241c0c921c", description = "Store UUID") @PathVariable(value = "uuid") UUID uuid) {
		return ResponseEntity.ok(service.findByUUID(uuid));
	}

	@Secured({ "ROLE_ADMIN", "ROLE_OWNER" })
	@GetMapping("/all")
	@Operation(summary = "Find All Store")
	public ResponseEntity<Page<ResponseStoreDTO>> findAll(Pageable pageable) {
		return ResponseEntity.ok(service.findAll(pageable));
	}

	@Secured({ "ROLE_ADMIN", "ROLE_OWNER" })
	@PostMapping("/create")
	public ResponseEntity<Void> createStore(@RequestBody CreateStoreRequestDTO dto) {
		service.createStore(dto);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}

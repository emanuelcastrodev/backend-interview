package com.store.controllers.v2.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.dtos.v1.store.CreateStoreRequestDTO;
import com.store.dtos.v2.store.ResponseStoreDTOWithHateos;
import com.store.services.v2.StoreServiceImplWithHateos;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/store/v2")
@SecurityRequirement(name = "security_auth")
public class StoreControllerV2 {

	@Autowired
	StoreServiceImplWithHateos service;

	@Secured({ "ROLE_ADMIN", "ROLE_OWNER" })
	@PostMapping("/create")
	public ResponseEntity<ResponseStoreDTOWithHateos> createStore(@RequestBody CreateStoreRequestDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
	}
}

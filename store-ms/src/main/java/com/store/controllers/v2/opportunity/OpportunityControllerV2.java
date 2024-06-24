package com.store.controllers.v2.opportunity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.dtos.v1.opportunity.CreateOpportunityRequestDTO;
import com.store.dtos.v2.opportunity.ResponseOpportunityDTOWithHateos;
import com.store.services.v2.OpportunityServiceImplWithHateos;
import com.store.utils.JwtUtils;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/opportunity/v2")
@SecurityRequirement(name = "security_auth")
public class OpportunityControllerV2 {

	@Autowired
	OpportunityServiceImplWithHateos service;

	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/create")
	public ResponseEntity<ResponseOpportunityDTOWithHateos> createOpportunity(
			@RequestBody CreateOpportunityRequestDTO dto, @AuthenticationPrincipal Jwt jwt) {
		CreateOpportunityRequestDTO dtoWithProfileUUID = new CreateOpportunityRequestDTO(
				jwtUtils.getProfileUUIDFromJWT(jwt), dto.storeUUID(), dto.carUUID());
		return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dtoWithProfileUUID));
	}
}

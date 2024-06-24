package com.store.controllers.v1.opportunity;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.dtos.v1.exceptions.ResponseExceptionDTO;
import com.store.dtos.v1.opportunity.CreateOpportunityRequestDTO;
import com.store.dtos.v1.opportunity.ResponseOpportunityDTO;
import com.store.dtos.v1.opportunity.UpdateOpportunityDescriptionDTO;
import com.store.services.v1.OpportunityServiceImpl;
import com.store.utils.JwtUtils;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/opportunity/v1")
@SecurityRequirement(name = "security_auth")
public class OpportunityController {

	@Autowired
	OpportunityServiceImpl service;

	@Autowired
	JwtUtils jwtUtils;

	@GetMapping("/{uuid}")
	@Operation(summary = "Find Opportunity", description = "Find Opportunity by UUID", responses = {
			@ApiResponse(description = "Success", responseCode = "200", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseOpportunityDTO.class)) }),
			@ApiResponse(description = "Not Found", responseCode = "400", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseExceptionDTO.class)) }) })
	public ResponseEntity<ResponseOpportunityDTO> findByUuid(
			@Parameter(name = "uuid", example = "7e2c0193-9aaf-4838-b957-d5241c0c921c", description = "Opportunity UUID") @PathVariable UUID uuid) {
		return ResponseEntity.ok(service.findByUUID(uuid));
	}

	@GetMapping("/all")
	@Operation(summary = "Find All Opportunities")
	public ResponseEntity<Page<ResponseOpportunityDTO>> findAll(Pageable pageable) {
		return ResponseEntity.ok().body(service.findAll(pageable));
	}

	@PostMapping("/create")
	public ResponseEntity<Void> createOpportunity(@RequestBody CreateOpportunityRequestDTO dto,
			@AuthenticationPrincipal Jwt jwt) {
		CreateOpportunityRequestDTO dtoWithProfileUUID = new CreateOpportunityRequestDTO(
				jwtUtils.getProfileUUIDFromJWT(jwt), dto.storeUUID(), dto.carUUID());
		service.createOpportunity(dtoWithProfileUUID);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@Secured({ "ROLE_ASSISTANT", "ROLE_ADMIN", "ROLE_OWNER" })
	@PutMapping("/set-assistant/{uuid}")
	@Operation(summary = "Set Assistant", description = "This route takes the user's profile_uuid through the JWT token and defines it as an assistant for the accessed opportunity.")
	public ResponseEntity<Void> setAssitant(
			@Parameter(name = "uuid", example = "7e2c0193-9aaf-4838-b957-d5241c0c921c", description = "Opportunity UUID") @PathVariable UUID uuid,
			@AuthenticationPrincipal Jwt jwt) {
		service.updateAssistante(uuid, jwtUtils.getProfileUUIDFromJWT(jwt));
		return ResponseEntity.ok().build();
	}

	@Secured({ "ROLE_ASSISTANT", "ROLE_ADMIN", "ROLE_OWNER" })
	@PutMapping("/set-close/{uuid}")
	@Operation(summary = "Find Opportunity", description = "Find Opportunity by UUID", requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(schema = @Schema(implementation = UpdateOpportunityDescriptionDTO.class))))
	public ResponseEntity<Void> closeOpportunity(
			@Parameter(name = "uuid", example = "7e2c0193-9aaf-4838-b957-d5241c0c921c", description = "Opportunity UUID") @PathVariable UUID uuid,
			@AuthenticationPrincipal Jwt jwt, @RequestBody UpdateOpportunityDescriptionDTO dto) {
		service.closeOpportunity(uuid, jwtUtils.getProfileUUIDFromJWT(jwt), dto);
		return ResponseEntity.ok().build();
	}
}

package com.store.dtos.v1.car;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.store.dtos.v1.opportunity.ResponseOpportunityDTO;

public record ResponseCarDTO(UUID uuid, String brand, String version, @JsonProperty("model_year") Integer modelYear,
		List<ResponseOpportunityDTO> opportunities) {

}

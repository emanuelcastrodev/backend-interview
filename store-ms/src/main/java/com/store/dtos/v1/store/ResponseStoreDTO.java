package com.store.dtos.v1.store;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.store.dtos.v1.opportunity.ResponseOpportunityDTO;

public record ResponseStoreDTO(UUID uuid, String cnpj, @JsonProperty("social_name") String socialName,
		List<ResponseOpportunityDTO> opportunities) {

}

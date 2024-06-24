package com.store.dtos.v1.opportunity;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public record CreateOpportunityRequestDTO(@JsonIgnore UUID clientUUID, @JsonProperty("store_uuid") UUID storeUUID,
		@JsonProperty("car_uuid") UUID carUUID) {

}

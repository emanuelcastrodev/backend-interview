package com.store.dtos.v1.opportunity;

import java.time.Instant;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.store.enums.OpportunityStatus;

public record ResponseOpportunityDTO(UUID uuid, @JsonProperty("client_uuid") UUID clientUUID, String description,
		@JsonProperty("start_date") Instant startDate, @JsonProperty("closing_date") Instant closingDate,
		@JsonProperty("car_uuid") UUID carUUID, @JsonProperty("store_uuid") UUID storeUUID,
		@JsonProperty("assistant_uuid") UUID assistantUUID, OpportunityStatus status) {

}

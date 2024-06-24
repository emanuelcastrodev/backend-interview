package com.store.dtos.v1.opportunity;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UpdateOpportunityAssistantRequestDTO(@JsonProperty("assistant_uuid") UUID assistantUUID) {

}

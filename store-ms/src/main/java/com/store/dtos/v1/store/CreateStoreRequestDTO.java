package com.store.dtos.v1.store;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CreateStoreRequestDTO(String cnpj, @JsonProperty("social_name") String socialName) {

}

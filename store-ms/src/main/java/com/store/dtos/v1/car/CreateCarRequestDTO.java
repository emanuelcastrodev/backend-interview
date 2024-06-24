package com.store.dtos.v1.car;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CreateCarRequestDTO(String brand, String version, @JsonProperty("model_year") Integer modelYear) {

}

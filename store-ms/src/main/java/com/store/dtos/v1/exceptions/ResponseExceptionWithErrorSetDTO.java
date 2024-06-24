package com.store.dtos.v1.exceptions;

import java.time.Instant;
import java.util.Set;

public record ResponseExceptionWithErrorSetDTO(Instant timestamp, Integer status, Set<String> errors, String path) {

}
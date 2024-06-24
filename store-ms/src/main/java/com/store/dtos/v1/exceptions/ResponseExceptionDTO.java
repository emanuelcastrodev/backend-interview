package com.store.dtos.v1.exceptions;

import java.time.Instant;

public record ResponseExceptionDTO(Instant timestamp, Integer status, String message, String path) {

}
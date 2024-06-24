package com.store.infra.exceptions.handlers;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.store.dtos.v1.exceptions.ResponseExceptionDTO;
import com.store.infra.exceptions.car.CarNotFoundException;

@RestControllerAdvice
public class CarExceptionHandler {

	@ExceptionHandler(CarNotFoundException.class)
	public ResponseEntity<ResponseExceptionDTO> storeExceptionHandler(CarNotFoundException ex, WebRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		ResponseExceptionDTO response = new ResponseExceptionDTO(Instant.now(), status.value(), ex.getMessage(),
				request.getDescription(false));
		return ResponseEntity.status(status).body(response);
	}
}

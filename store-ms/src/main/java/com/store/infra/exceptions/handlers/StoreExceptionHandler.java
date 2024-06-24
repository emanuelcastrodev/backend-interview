package com.store.infra.exceptions.handlers;

import java.time.Instant;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.store.dtos.v1.exceptions.ResponseExceptionDTO;
import com.store.dtos.v1.exceptions.ResponseExceptionWithErrorSetDTO;
import com.store.infra.exceptions.store.StoreAlreadyExistsException;
import com.store.infra.exceptions.store.StoreNotFoundException;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class StoreExceptionHandler {

	@ExceptionHandler(StoreNotFoundException.class)
	public ResponseEntity<ResponseExceptionDTO> storeExceptionHandler(StoreNotFoundException ex, WebRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		ResponseExceptionDTO response = new ResponseExceptionDTO(Instant.now(), status.value(), ex.getMessage(),
				request.getDescription(false));
		return ResponseEntity.status(status).body(response);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ResponseExceptionWithErrorSetDTO> storeExceptionHandler(ConstraintViolationException ex,
			WebRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		ResponseExceptionWithErrorSetDTO response = new ResponseExceptionWithErrorSetDTO(Instant.now(), status.value(),
				ex.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.toSet()),
				request.getDescription(false));
		return ResponseEntity.status(status).body(response);
	}

	@ExceptionHandler(StoreAlreadyExistsException.class)
	public ResponseEntity<ResponseExceptionDTO> storeExceptionHandler(StoreAlreadyExistsException ex,
			WebRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		ResponseExceptionDTO response = new ResponseExceptionDTO(Instant.now(), status.value(), ex.getMessage(),
				request.getDescription(false));
		return ResponseEntity.status(status).body(response);
	}
}

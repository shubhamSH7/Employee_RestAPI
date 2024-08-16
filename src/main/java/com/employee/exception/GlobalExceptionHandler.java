package com.employee.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> validation(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach(err -> {
			String fieldname = ((FieldError) err).getField();
			String error = err.getDefaultMessage();
			errors.put(fieldname, error);
		});

		return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<String> notFound(EmployeeNotFoundException ex) {
		String msg = ex.getMessage();
		return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(UserExistsException.class)
	public ResponseEntity<String> notFound(UserExistsException ex) {
		String msg = ex.getMessage();
		return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(EmployeeExistsException.class)
	public ResponseEntity<String> empExists(EmployeeExistsException ex) {
		String msg = ex.getMessage();
		return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
	}

}

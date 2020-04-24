package com.spring.jpa.app.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {
	@org.springframework.web.bind.annotation.ExceptionHandler(value = {NullPointerException.class})
	public ResponseEntity<Object> handleNullPointer(NullPointerException ex, WebRequest request) {
		return new ResponseEntity<>(
					ex,
					new HttpHeaders(),
					HttpStatus.INTERNAL_SERVER_ERROR
				);
	}
}

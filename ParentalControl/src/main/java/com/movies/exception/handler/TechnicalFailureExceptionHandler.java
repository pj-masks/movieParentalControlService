package com.movies.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.movies.exception.TechnicalFailureException;

@ControllerAdvice
public class TechnicalFailureExceptionHandler {

	@ExceptionHandler(TechnicalFailureException.class)
	public ResponseEntity<Boolean> handle() {
		return new ResponseEntity<Boolean>(Boolean.FALSE, HttpStatus.OK);
	}

}

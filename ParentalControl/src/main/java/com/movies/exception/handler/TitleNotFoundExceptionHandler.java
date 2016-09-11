package com.movies.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.movies.exception.TitleNotFoundException;

@ControllerAdvice
public class TitleNotFoundExceptionHandler {

	@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "This movie title is not found.")
	@ExceptionHandler(TitleNotFoundException.class)
	public void handle() {
	}

}

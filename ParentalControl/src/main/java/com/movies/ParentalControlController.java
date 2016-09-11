package com.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.movies.exception.TechnicalFailureException;
import com.movies.exception.TitleNotFoundException;
import com.movies.model.Input;
import com.movies.service.ParentalControlService;

@RestController
public class ParentalControlController {

	private final ParentalControlService parentalControlService;

	@Autowired
	public ParentalControlController(final ParentalControlService parentalControlService) {
		this.parentalControlService = parentalControlService;
	}

	@RequestMapping(value = "/parental-control", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> isMoviePermitted(@RequestBody Input input)
			throws TitleNotFoundException, TechnicalFailureException {
		return new ResponseEntity<Boolean>(parentalControlService.isMoviePermitted(input), HttpStatus.OK);

	}

}

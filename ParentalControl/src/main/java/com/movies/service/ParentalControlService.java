package com.movies.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movies.exception.TechnicalFailureException;
import com.movies.exception.TitleNotFoundException;
import com.movies.model.Input;
import com.movies.proxy.MovieService;

@Service
public class ParentalControlService {

	private final MovieService movieService;
	private Map<String, Integer> parentControlLevelMap = new HashMap<>();

	@Autowired
	public ParentalControlService(final MovieService movieService) {
		this.movieService = movieService;
		parentControlLevelMap.put("U", 1);
		parentControlLevelMap.put("PG", 2);
		parentControlLevelMap.put("12", 3);
		parentControlLevelMap.put("15", 4);
		parentControlLevelMap.put("18", 5);
	}

	public Boolean isMoviePermitted(Input input) throws TitleNotFoundException, TechnicalFailureException {
		return parentControlLevelMap.get(input.getParentalControlLevelPreference()) >= parentControlLevelMap
				.get(movieService.getParentalControlLevel(input.getMovieId()));
	}

}

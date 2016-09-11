package com.movies.proxy;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.movies.exception.TechnicalFailureException;
import com.movies.exception.TitleNotFoundException;

@Component
public class MovieServiceStub implements MovieService {

	Map<String, String> movieRatingMap = new HashMap<>();

	public MovieServiceStub() {
		movieRatingMap.put("A", "U");
		movieRatingMap.put("B", "PG");
		movieRatingMap.put("C", "12");
		movieRatingMap.put("D", "15");
		movieRatingMap.put("E", "18");
		movieRatingMap.put("F", "NA");
	}

	@Override
	public String getParentalControlLevel(String movieId) throws TitleNotFoundException, TechnicalFailureException {
		String rating = movieRatingMap.get(movieId);
		if (rating == null) {
			throw new TitleNotFoundException();
		} else if (rating == "NA") {
			throw new TechnicalFailureException();
		}
		return rating;
	}

}

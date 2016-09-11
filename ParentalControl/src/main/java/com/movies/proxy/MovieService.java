package com.movies.proxy;

import com.movies.exception.TechnicalFailureException;
import com.movies.exception.TitleNotFoundException;

public interface MovieService {
	public String getParentalControlLevel(String movieId) throws TitleNotFoundException, TechnicalFailureException;
}
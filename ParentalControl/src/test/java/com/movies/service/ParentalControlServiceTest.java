package com.movies.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.movies.exception.TechnicalFailureException;
import com.movies.exception.TitleNotFoundException;
import com.movies.model.Input;
import com.movies.proxy.MovieService;

public class ParentalControlServiceTest {

	@Mock
	private MovieService movieService;

	private ParentalControlService parentalControlService;

	@Before
	public void setupMock() throws IOException {
		MockitoAnnotations.initMocks(this);
		parentalControlService = new ParentalControlService(movieService);
	}

	@Test
	public void testIsMoviePermittedReturnsTrueWhenMovieParentalControlIsLessThanCustomerParentalPreference()
			throws TitleNotFoundException, TechnicalFailureException {
		Input input = new Input("C", "15");
		when(movieService.getParentalControlLevel("C")).thenReturn("12");
		assertEquals(Boolean.TRUE, parentalControlService.isMoviePermitted(input));
	}

	@Test
	public void testIsMoviePermittedReturnsTrueWhenMovieParentalControlIsEqualToCustomerParentalPreference()
			throws TitleNotFoundException, TechnicalFailureException {
		Input input = new Input("C", "15");
		when(movieService.getParentalControlLevel("C")).thenReturn("15");
		assertEquals(Boolean.TRUE, parentalControlService.isMoviePermitted(input));
	}

	@Test
	public void testIsMoviePermittedReturnsFalseWhenMovieParentalControlIsMoreThanCustomerParentalPreference()
			throws TitleNotFoundException, TechnicalFailureException {
		Input input = new Input("C", "15");
		when(movieService.getParentalControlLevel("C")).thenReturn("18");
		assertEquals(Boolean.FALSE, parentalControlService.isMoviePermitted(input));
	}

	@Test(expected = TitleNotFoundException.class)
	public void testIsMoviePermittedThrowsExceptionWhenMovieTitleIsNotFound()
			throws TitleNotFoundException, TechnicalFailureException {
		Input input = new Input("ABC", "15");
		when(movieService.getParentalControlLevel("ABC")).thenThrow(new TitleNotFoundException());
		parentalControlService.isMoviePermitted(input);
	}

	@Test(expected = TechnicalFailureException.class)
	public void testIsMoviePermittedThrowsExceptionWhenTechnicalFailureHappens()
			throws TitleNotFoundException, TechnicalFailureException {
		Input input = new Input("F", "15");
		when(movieService.getParentalControlLevel("F")).thenThrow(new TechnicalFailureException());
		parentalControlService.isMoviePermitted(input);
	}

}

package com.movies.model;

public class Input {

	private String movieId;
	private String parentalControlLevelPreference;

	public Input() {

	}

	public Input(final String movieId, final String parentalControlLevelPreference) {
		this.movieId = movieId;
		this.parentalControlLevelPreference = parentalControlLevelPreference;
	}

	public String getParentalControlLevelPreference() {
		return parentalControlLevelPreference;
	}

	public void setParentalControlLevelPreference(String parentalControlLevelPreference) {
		this.parentalControlLevelPreference = parentalControlLevelPreference;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieID) {
		this.movieId = movieID;
	}

}

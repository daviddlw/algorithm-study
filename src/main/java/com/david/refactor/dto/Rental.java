package com.david.refactor.dto;

public class Rental {
	private Movie movie;
	private int daysRented;

	public Rental(Movie movie, int daysRented) {
		super();
		this.movie = movie;
		this.daysRented = daysRented;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public int getDaysRented() {
		return daysRented;
	}

	public void setDaysRented(int daysRented) {
		this.daysRented = daysRented;
	}

	// move methods
	public double getCharge(int daysRented) {
		return movie.getCharge(daysRented);
	}

	public int getFrequentRenterPoints(int daysRented) {
		return movie.getFrequentRenterPoints(daysRented);
	}
}

package com.david.refactor.dto;

public class Movie {
	public static final int CHILDRENS = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;

	private String title;
	private int priceCode;
	private Price price;

	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Movie(String title, int priceCode) {
		super();
		this.title = title;
		setPriceCode(priceCode);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPriceCode() {
		return price.getPriceCode();
	}

	public void setPriceCode(int priceCode) {
		switch (priceCode) {
		case REGULAR:
			price = new RegularPrice();
			break;
		case NEW_RELEASE:
			price = new NewReleasePrice();
			break;
		case CHILDRENS:
			price = new ChildrenPrice();
			break;
		default:
			throw new IllegalArgumentException("Incorrect price code");
		}
	}

	// move methods
	public double getCharge(int daysRented) {
		double result = 0;
		// determine amounts for each line
		switch (getPriceCode()) {
		case Movie.REGULAR:
			result += 2;
			if (daysRented > 2) {
				result += (daysRented - 2) * 1.5;
			}
			break;
		case Movie.NEW_RELEASE:
			result += daysRented * 3;
			break;
		case Movie.CHILDRENS:
			result += 1.5;
			if (daysRented > 3) {
				result += (daysRented - 3) * 1.5;
			}
			break;
		}

		return result;
	}

	public int getFrequentRenterPoints(int daysRented) {
		// add bouns for a two day new release rental
		if ((getPriceCode() == Movie.NEW_RELEASE) && (daysRented > 1)) {
			return 2;
		} else {
			return 1;
		}
	}
}

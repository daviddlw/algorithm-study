package com.david.refactor.dto;

public class Movie {
	public static final int CHILDRENS = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;

	private String title;
	@SuppressWarnings("unused")
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
		return price.getCharge(daysRented);
	}

	public int getFrequentRenterPoints(int daysRented) {
		return price.getFrequentRenterPoints(daysRented);
	}
}

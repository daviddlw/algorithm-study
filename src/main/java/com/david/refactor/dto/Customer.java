package com.david.refactor.dto;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String name;
	private List<Rental> rentals = new ArrayList<>();

	public Customer(String name) {
		super();
		this.name = name;
	}

	public void addRental(Rental rental) {
		rentals.add(rental);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Rental> getRentals() {
		return rentals;
	}

	public String statement() {
		String result = "Rental record for " + getName() + "\n";
		for (Rental rental : rentals) {
			Rental each = rental;
			// show figures for this rental
			result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge(rental.getDaysRented())) + "\n";
		}

		// add footer lines;
		result += "Amount owned is " + String.valueOf(getTotalCharge()) + "\n";
		result += "You earned " + String.valueOf(getFrequentRenterPoints()) + " frequent renter points";
		return result;
	}

	private double getTotalCharge() {
		double result = 0;
		for (Rental rental : rentals) {
			result += rental.getCharge(rental.getDaysRented());
		}
		return result;
	}
	
	private int getFrequentRenterPoints() {
		int result = 0;
		for (Rental rental : rentals) {
			result += rental.getFrequentRenterPoints(rental.getDaysRented());
		}
		return result;
	}

	@SuppressWarnings("unused")
	private double amountFor(Rental aRental) {
		return aRental.getCharge(aRental.getDaysRented());
	}

}

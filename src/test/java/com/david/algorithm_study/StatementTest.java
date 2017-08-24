package com.david.algorithm_study;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import com.david.refactor.dto.Customer;
import com.david.refactor.dto.Movie;
import com.david.refactor.dto.Rental;

public class StatementTest {

	@Test
	public void testRefactor() {

		Movie movie1 = new Movie(RandomStringUtils.randomAlphabetic(6), Movie.CHILDRENS);
		Movie movie2 = new Movie(RandomStringUtils.randomAlphabetic(6), Movie.NEW_RELEASE);
		Movie movie3 = new Movie(RandomStringUtils.randomAlphabetic(6), Movie.REGULAR);
		Movie movie4 = new Movie(RandomStringUtils.randomAlphabetic(6), Movie.REGULAR);
		Movie movie5 = new Movie(RandomStringUtils.randomAlphabetic(6), Movie.NEW_RELEASE);
		Movie movie6 = new Movie(RandomStringUtils.randomAlphabetic(6), Movie.REGULAR);

		Rental rental1 = new Rental(movie1, 3);
		Rental rental2 = new Rental(movie2, 5);
		Rental rental3 = new Rental(movie3, 1);
		Rental rental4 = new Rental(movie4, 3);
		Rental rental5 = new Rental(movie5, 6);
		Rental rental6 = new Rental(movie6, 3);

		Customer customer1 = new Customer("david");
		customer1.addRental(rental1);
		customer1.addRental(rental2);

		Customer customer2 = new Customer("muchen");
		customer2.addRental(rental3);
		customer2.addRental(rental4);
		customer2.addRental(rental5);
		customer2.addRental(rental6);

		System.out.println(customer1.statement());
		System.out.println(customer2.statement());
	}

	@Test
	public void test() {
		System.out.println(1 & 1);
		System.out.println(2 & 4);
	}
	
	@Test
	public void testV2() {
		Person person = new Person();
		Department department = new Department();
		department.setChargeCode("daviddai");
		department.setManager(person);
		person.setDepartment(department);
		System.out.println(person.getDepartment().getManager());
	}

}

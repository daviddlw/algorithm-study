package com.david.refactor.dto;

public abstract class Price {
	abstract int getPriceCode();
}

class ChildrenPrice extends Price {

	@Override
	int getPriceCode() {
		return Movie.CHILDRENS;
	}

}

class NewReleasePrice extends Price {

	@Override
	int getPriceCode() {
		return Movie.NEW_RELEASE;
	}

}

class RegularPrice extends Price{

	@Override
	int getPriceCode() {
		return Movie.REGULAR;
	}
	
}

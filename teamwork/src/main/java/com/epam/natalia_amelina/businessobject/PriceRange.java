package com.epam.natalia_amelina.businessobject;

public class PriceRange {

	private int priceFrom = 0;
	private int priceTo = 0;
	
	/*
	public PriceRange(int priceFrom, int priceTo) {
		this.priceFrom = priceFrom;
		this.priceTo = priceTo;
	}*/

	public int getPriceFrom() {
		return priceFrom;
	}

	public void setPriceFrom(int priceFrom) {
		this.priceFrom = priceFrom;
	}
	
	public int getPriceTo() {
		return priceTo;
	}
	
	public void setPriceTo(int priceTo) {
		this.priceTo = priceTo;
	}

}

package com.epam.natalia_amelina.patterns.builder;

public class PriceRangeTwo extends BasePriceRange {

	private static final int PRICE_FROM = 200;
	private static final int PRICE_TO = 300;
	
	@Override
	public void createPriceFrom() {
		priceRange.setPriceFrom(PRICE_FROM);
		
	}

	@Override
	public void createPriceTo() {
		priceRange.setPriceTo(PRICE_TO);
		
	}

}

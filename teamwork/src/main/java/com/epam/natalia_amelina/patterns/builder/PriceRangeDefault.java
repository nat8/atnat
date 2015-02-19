package com.epam.natalia_amelina.patterns.builder;

public class PriceRangeDefault extends BasePriceRange {

	private static final int PRICE_FROM = 450;
	private static final int PRICE_TO = 485;
	
	@Override
	public void createPriceFrom() {
		priceRange.setPriceFrom(PRICE_FROM);
		
	}

	@Override
	public void createPriceTo() {
		priceRange.setPriceTo(PRICE_TO);
		
	}
}

package com.epam.natalia_amelina.patterns.builder;

import com.epam.natalia_amelina.businessobject.PriceRange;

public abstract class BasePriceRange {

	protected PriceRange priceRange = new PriceRange();
	
	public PriceRange getPriceRange() {
		return priceRange;
	}
	
	public abstract void createPriceFrom();
	
	public abstract void createPriceTo();
	
}

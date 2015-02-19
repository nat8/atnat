package com.epam.natalia_amelina.patterns.builder;

import com.epam.natalia_amelina.businessobject.PriceRange;

public class PriceRangeBuilder {

	public static PriceRange BuildPriceRange(BasePriceRange priceRange) {
		priceRange.createPriceFrom();
		priceRange.createPriceTo();
		return priceRange.getPriceRange();
	}
}

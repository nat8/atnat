package com.epam.natalia_amelina.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.epam.natalia_amelina.businessobject.PriceRange;
import com.epam.natalia_amelina.patterns.builder.PriceRangeBuilder;
import com.epam.natalia_amelina.patterns.builder.PriceRangeDefault;
import com.epam.natalia_amelina.patterns.factorymethod.CheckInTest;
import com.epam.natalia_amelina.patterns.factorymethod.CheckPrice;
import com.epam.natalia_amelina.test.base.BeforeAfterTest;

public class FilterOnPriceTest extends BeforeAfterTest {

	private static final String ERROR_INCORRECT_PRICE = "Error! There are watches with incorrect prices after filtering!";
	
	private CheckInTest checkInTest = new CheckPrice();
	
	@Test
	public void filterOnPriceTest() {
		PriceRange priceRange = PriceRangeBuilder
								.BuildPriceRange(new PriceRangeDefault());
		loginOnSite().goToAccessoriesWatchPage().applyPriceFilter(priceRange);
		Assert.assertTrue(checkInTest.check(getDriver(), priceRange), 
						  ERROR_INCORRECT_PRICE);
		getDriver().navigate().refresh();
	}
	
}

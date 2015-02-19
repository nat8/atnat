package com.epam.natalia_amelina.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.epam.natalia_amelina.businessobject.Product;
import com.epam.natalia_amelina.patterns.factorymethod.CheckBrand;
import com.epam.natalia_amelina.patterns.factorymethod.CheckInTest;
import com.epam.natalia_amelina.test.base.BeforeAfterTest;

public class FilterOnBrandTest extends BeforeAfterTest {

	private static final String ERROR_INCORRECT_BRAND = "Error! There are products with incorrect brands after filtering!";
	private CheckInTest checkInTest = new CheckBrand();
	
	private String brand = "Nixon";
	
	@Test
	public void filterOnBrandTest() {
		Product product = new Product(brand);
		loginOnSite().goToAccessoriesPage().applyBrandFilter(brand);
		Assert.assertTrue(checkInTest.check(getDriver(), product), 
						  ERROR_INCORRECT_BRAND);
	}
	
}

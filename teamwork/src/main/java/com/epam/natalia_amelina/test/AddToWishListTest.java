package com.epam.natalia_amelina.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.epam.natalia_amelina.businessobject.Product;
import com.epam.natalia_amelina.patterns.factorymethod.CheckInTest;
import com.epam.natalia_amelina.patterns.factorymethod.CheckWish;
import com.epam.natalia_amelina.test.base.BeforeAfterTest;
import com.epam.natalia_amelina.ui.pageobject.MainMenuPage;

public class AddToWishListTest extends BeforeAfterTest {

	private static final String ERROR_NOT_WISH = "Error! Products not found in wish list!";
	private CheckInTest checkInTest = new CheckWish();
	
	@Test
	public void addToWishListTest() {
		Product product = wishProduct();
		Assert.assertTrue(checkInTest.check(getDriver(), product), ERROR_NOT_WISH);
		clearWishList();
	}
	
	private void clearWishList() {
		new MainMenuPage(getDriver()).goToWishPage().removeLast();
		getDriver().navigate().refresh();
	}
	
}

package com.epam.natalia_amelina.patterns.factorymethod;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.epam.natalia_amelina.businessobject.PriceRange;
import com.epam.natalia_amelina.businessobject.Product;
import com.epam.natalia_amelina.ui.pageobject.MainMenuPage;
import com.epam.natalia_amelina.util.StringProcessing;

public class CheckWish extends CheckInTest {

	private static final String WISH_PRODUCT_TR = "wListItem";
	private static final String NAME_LINK = "wishlist.product.name";
	private static final String PRICE_WISH_SPAN = "price";
	
	@Override
	public boolean check(WebDriver driver, Product product) {
		return checkInWishList(driver, product);
	}

	@Override
	public boolean check(WebDriver driver, PriceRange priceRange) {
		return false;
	}
	
	private boolean checkInWishList(WebDriver driver, Product wish) {
		goToWishList(driver);
		List<WebElement> wishProductTr = 
				driver.findElements(By.className(WISH_PRODUCT_TR));
		for (WebElement currentProduct:wishProductTr) {
			WebElement productInfo = currentProduct
									.findElement(By.name(NAME_LINK));
			WebElement productPrice = 
					currentProduct.findElement(By.className(PRICE_WISH_SPAN));
			Product actualProduct = new Product(StringProcessing
												.convertToBrand(productInfo.getText()), 
												productPrice.getText());
			if (checkBrandAndPrice(actualProduct, wish)) {
				return true;
			}
		}
		return false;
	}
	
	private void goToWishList(WebDriver driver) {
		new MainMenuPage(driver).goToWishPage();
		driver.navigate().refresh();
	}
	
	private boolean checkBrandAndPrice(Product actualProduct, 
											  Product wish) {
		if ((actualProduct.getBrand().equalsIgnoreCase(wish.getBrand())) 
				&& (actualProduct.getPrice() == wish.getPrice())) {
			return true;
		}
		return false;
	}

}

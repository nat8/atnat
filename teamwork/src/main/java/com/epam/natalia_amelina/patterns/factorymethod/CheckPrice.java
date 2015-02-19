package com.epam.natalia_amelina.patterns.factorymethod;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.epam.natalia_amelina.businessobject.PriceRange;
import com.epam.natalia_amelina.businessobject.Product;
import com.epam.natalia_amelina.util.StringProcessing;

public class CheckPrice extends CheckInTest {

	private static final String PRODUCT_LI = "gItem";
	private static final String PRICE_SPAN_CURRENT = "price";
	
	@Override
	public boolean check(WebDriver driver, Product product) {
		return false;
	}

	@Override
	public boolean check(WebDriver driver, PriceRange priceRange) {
		return checkPrice(driver, priceRange);
	}
	
	private boolean checkPrice(WebDriver driver, PriceRange priceRange) {
		int currentPrice = 0;
		List<WebElement> filteredWatches = 
				driver.findElements(By.className(PRODUCT_LI));
		for (WebElement currentWatches : filteredWatches) {
			List<WebElement> filteredPriceList = 
					currentWatches.findElements(By.className(PRICE_SPAN_CURRENT));
			for(WebElement currentElement : filteredPriceList) {
				currentPrice = StringProcessing
							   .convertPriceToInt(currentElement.getText());
				if (!((currentPrice >= priceRange.getPriceFrom()) 
						&& (currentPrice <= priceRange.getPriceTo()))) {
					return false;
				}
			}
		}
		return true;
	}

}

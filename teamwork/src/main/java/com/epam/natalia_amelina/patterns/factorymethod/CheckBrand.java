package com.epam.natalia_amelina.patterns.factorymethod;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.epam.natalia_amelina.businessobject.PriceRange;
import com.epam.natalia_amelina.businessobject.Product;

public class CheckBrand extends CheckInTest {

	private static final String PRODUCT_LI = "gItem";
	private static final String BRAND_CURRENT = "b";
	
	@Override
	public boolean check(WebDriver driver, Product product) {
		return checkBrands(driver, product);
	}

	@Override
	public boolean check(WebDriver driver, PriceRange priceRange) {
		return false;
	}
	
	private boolean checkBrands(WebDriver driver, Product product) {
		List<WebElement> filteredProducts = 
				driver.findElements(By.className(PRODUCT_LI));
		for (WebElement currentProduct : filteredProducts) {
			List<WebElement> filteredBrandList = 
					currentProduct.findElements(By.tagName(BRAND_CURRENT));
			for (WebElement currentBrand : filteredBrandList) {
				if (!(currentBrand.getText().equalsIgnoreCase(product.getBrand()))) {
					return false;
				}
			}
		}
		return true;
	}

}

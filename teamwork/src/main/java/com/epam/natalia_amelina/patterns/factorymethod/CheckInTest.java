package com.epam.natalia_amelina.patterns.factorymethod;

import org.openqa.selenium.WebDriver;

import com.epam.natalia_amelina.businessobject.PriceRange;
import com.epam.natalia_amelina.businessobject.Product;

public abstract class CheckInTest {

	public abstract boolean check(WebDriver driver, Product product);
	
	public abstract boolean check(WebDriver driver, PriceRange priceRange);
}

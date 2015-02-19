package com.epam.natalia_amelina.util;

import org.openqa.selenium.WebElement;

public class ElementPresent {

	public static boolean isElementPresent(WebElement element) {
		try {
			return element.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
}

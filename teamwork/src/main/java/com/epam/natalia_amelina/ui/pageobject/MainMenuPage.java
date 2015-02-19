package com.epam.natalia_amelina.ui.pageobject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;

import com.epam.natalia_amelina.util.ElementPresent;

public class MainMenuPage {

	private static final int WAIT = 15;
	private static final int STEP = 3;
	
	private WebDriver driver;
	
	@FindBy(id = "modalLoginLinkAccountAccountBox")
	private WebElement loginLink;
	
	@FindBy(id = "WishList") 
	private WebElement wishListLink;
	
	@FindBy(id = "unisexAccessoriesNav")
	private WebElement accessoriesButton;
	
	@FindBy(linkText = "Watches")
	private WebElement watchesLink;
	
	public MainMenuPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getAccessoriesButton() {
		return accessoriesButton;
	}
	
	public LoginWindow goToLoginWindow() {
		new Actions(driver).click(loginLink).build().perform();
		return new LoginWindow(driver);
	}
	
	public WishPage goToWishPage() {
		new Actions(driver).click(wishListLink).build().perform();
		return new WishPage(driver);
	}
	
	public AccessoriesPage goToAccessoriesPage() {
		waitAccessoriesButton();
		new Actions(driver).click(accessoriesButton).build().perform();
		return new AccessoriesPage(driver);
	}

	public AccessoriesPage goToAccessoriesWatchPage() {
		new Actions(driver).moveToElement(accessoriesButton)
						   .click(watchesLink).build().perform();
		return new AccessoriesPage(driver);
	}
	
	private void waitAccessoriesButton() {
		new FluentWait<WebDriver>(driver).withTimeout(WAIT, TimeUnit.SECONDS)
			.pollingEvery(STEP, TimeUnit.SECONDS)
			.ignoring(NoSuchElementException.class)
			.until(new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver driver) {
					return ElementPresent.isElementPresent(accessoriesButton);
				}
			});
	}
	
}

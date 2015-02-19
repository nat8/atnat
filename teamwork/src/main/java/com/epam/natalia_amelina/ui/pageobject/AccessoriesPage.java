package com.epam.natalia_amelina.ui.pageobject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;

import com.epam.natalia_amelina.businessobject.PriceRange;
import com.epam.natalia_amelina.util.ElementPresent;

public class AccessoriesPage extends MainMenuPage {
	
	private static final int WAIT = 15;
	private static final int STEP = 3;
	
	private WebDriver driver;
	
	@FindBy(xpath = "//span[@title=\"Price\"]")
	private WebElement priceButton;
	
	@FindBy(xpath = "//span[@title=\"Brand\"]")
	private WebElement brandButton;
	
	@FindBy(name = "price_from")
	private WebElement priceFromInput;
	
	@FindBy(name = "price_to")
	private WebElement priceToInput;
	
	@FindBy(xpath = "//input[@value=\"Apply\"]")
	private WebElement applyButton;
	
	@FindBy(className = "gItem")
	private WebElement watchLi;
	
	@FindBy(className = "price")
	private WebElement productPriceSpan;
	
	@FindBy(className = "b")
	private WebElement productBrandSpan;
	
	@FindBy(className = "filtBut") 
	private WebElement checkedBrandLi;
	
	@FindBy(className = "content")
	private WebElement brandUl;
	
	public AccessoriesPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public AccessoriesPage applyPriceFilter(PriceRange priceRange) {
		waitPriceButton();
		priceButton.click();
		clickPriceButton();
		/*try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		waitInputPriceRange();
		inputPriceFrom(priceRange.getPriceFrom());
		inputPriceTo(priceRange.getPriceTo());
		clickApply();
		return new AccessoriesPage(driver);
	}
	
	private void waitPriceButton() {
		new FluentWait<WebDriver>(driver)
				.withTimeout(WAIT, TimeUnit.SECONDS)
				.pollingEvery(STEP, TimeUnit.SECONDS)
				.ignoring(InvalidElementStateException.class, NoSuchElementException.class)
				.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {	
				return ElementPresent.isElementPresent(priceButton);
			}
		});
	}
	
	private void clickPriceButton() {
		while (!(ElementPresent.isElementPresent(priceFromInput))) {
			priceButton.click();
		}
	}
	
	private void waitInputPriceRange() {
		new FluentWait<WebDriver>(driver)
				.withTimeout(WAIT, TimeUnit.SECONDS)
				.pollingEvery(STEP, TimeUnit.SECONDS)
				.ignoring(InvalidElementStateException.class)
				.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {	
				return ElementPresent.isElementPresent(priceFromInput);
			}
		});
	}
	
	private AccessoriesPage inputPriceFrom(int priceFrom) {
		priceFromInput.clear();
		new Actions(driver).sendKeys(priceFromInput, Integer.toString(priceFrom))
						   .build().perform();
		return new AccessoriesPage(driver);
	}
	
	private AccessoriesPage inputPriceTo(int priceTo) {
		priceToInput.clear();
		new Actions(driver).sendKeys(priceToInput, Integer.toString(priceTo))
						   .build().perform();
		return new AccessoriesPage(driver);
	}
	
	private AccessoriesPage clickApply() {
		new Actions(driver).click(applyButton).build().perform();
		return new AccessoriesPage(driver);
	}
	
	public AccessoriesPage applyBrandFilter(String brand) {
		brandClick();
		selectBrand(brand);
		clickApply();
		return new AccessoriesPage(driver);
	}
	
	private AccessoriesPage brandClick() {
		new Actions(driver).click(brandButton).build().perform();
		return new AccessoriesPage(driver);
	}
	
	private AccessoriesPage selectBrand(String brand) {
		WebElement brandInput = driver.findElement(By.linkText(brand));
		new Actions(driver).click(brandInput).build().perform();
		return new AccessoriesPage(driver);
	}
	
	public CurrentProductPage selectProduct() {
		new Actions(driver).click(watchLi).build().perform();
		return new CurrentProductPage(driver);
	}
	
}

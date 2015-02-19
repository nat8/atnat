package com.epam.natalia_amelina.ui.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishPage extends MainMenuPage {

	private WebDriver driver;
	
	@FindBy(className = "wListItem")
	private WebElement wishProduct;
	
	@FindBy(name = "wishlist.product.name")
	private WebElement productNameLike;
	
	@FindBy(className = "price")
	private WebElement productPriceSpan;
	
	@FindBy(className = "removeBut")
	private WebElement removeLink;
	
	public WishPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WishPage removeLast() {
		new Actions(driver).click(removeLink).build().perform();
		return new WishPage(driver);
	}
}

package com.epam.natalia_amelina.ui.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CurrentProductPage extends MainMenuPage {
	
	private WebDriver driver;
	private String brand;
	private String price; 
	
	@FindBy(xpath = "//span[@itemprop=\"brand\"]") 
	private WebElement brandSpan;
	
	@FindBy(id = "articlePrice") 
	private WebElement priceSpan;
	
	@FindBy(id = "addToWishlist") 
	private WebElement addToWishListButton;
	
	@FindBy(id = "articleOnWishlist") 
	private WebElement onWishListButton;
	
	public CurrentProductPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getBrand() {
		this.brand = brandSpan.getText();
		return brand;
	}
	
	public String getPrice() {
		this.price = priceSpan.getText();
		return price;
	}
	
	public CurrentProductPage addToWishList() {
		new Actions(driver).click(addToWishListButton).build().perform();
		return new CurrentProductPage(driver);
	}
}

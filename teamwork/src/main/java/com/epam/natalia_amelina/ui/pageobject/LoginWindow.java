package com.epam.natalia_amelina.ui.pageobject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;

import com.epam.natalia_amelina.util.ElementPresent;

public class LoginWindow extends MainMenuPage {
	
	private static final int WAIT = 15;
	private static final int STEP = 3;
	
	private WebDriver driver;

	@FindBy(id = "loginEmail")
	private WebElement loginInput;
	
	@FindBy(id = "loginPassword")
	private WebElement passwordInput;
	
	@FindBy(id = "login")
	private WebElement loginButton;
	
	public LoginWindow(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	private LoginWindow inputLogin(String login) {
		loginInput.clear();
		new Actions(driver).sendKeys(loginInput, login).build().perform();
		return new LoginWindow(driver);
	}
	
	private LoginWindow inputPassword(String password) {
		passwordInput.clear();
		new Actions(driver).sendKeys(passwordInput, password).build().perform();
		return new LoginWindow(driver);
	}
	
	public MainMenuPage loggingSite(String login, String password) {
		waitLoginWindow();
		inputLogin(login);
		inputPassword(password);
		new Actions(driver).click(loginButton).build().perform();
		return new MainMenuPage(driver);
	}
	
	private void waitLoginWindow() {
		new FluentWait<WebDriver>(driver)
				.withTimeout(WAIT, TimeUnit.SECONDS)
				.pollingEvery(STEP, TimeUnit.SECONDS)
				.ignoring(InvalidElementStateException.class)
				.until(new ExpectedCondition<Boolean>() {
					public Boolean apply(WebDriver driver) {	
						return ElementPresent.isElementPresent(loginInput);
					}
				});
	}
	
}

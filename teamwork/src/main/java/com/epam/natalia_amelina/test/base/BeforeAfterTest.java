package com.epam.natalia_amelina.test.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.epam.natalia_amelina.businessobject.Product;
import com.epam.natalia_amelina.businessobject.UserAccount;
import com.epam.natalia_amelina.patterns.singleton.SingleAccount;
import com.epam.natalia_amelina.ui.pageobject.CurrentProductPage;
import com.epam.natalia_amelina.ui.pageobject.MainMenuPage;
import com.epam.natalia_amelina.util.UserUrl;

public class BeforeAfterTest {

	private static final String RESOURCES_DRIVER = "src\\test\\resources\\chromedriver.exe";
	private static final String PROPERTY_NAME = "webdriver.chrome.driver";
	private static final int WAIT = 15;
	
	private WebDriver driver;
	
	@BeforeClass
	public void openBrowser() {
		System.setProperty(PROPERTY_NAME, RESOURCES_DRIVER);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(WAIT, TimeUnit.SECONDS);
	}
	
	@BeforeClass (dependsOnMethods = "openBrowser")
	public void goToMainPage() {
		driver.get(UserUrl.readUrlFromFile());
	}
	
	@BeforeClass (dependsOnMethods = "goToMainPage")
	public void resizeBrowserWindow() {
		driver.manage().window().maximize();
	}
	
	public MainMenuPage loginOnSite() {
		UserAccount userAccount = SingleAccount.getUserAccount();
		return new MainMenuPage(driver).goToLoginWindow()
									   .loggingSite(userAccount.getLogin(), 
											   		userAccount.getPassword());
	}
	
	public Product wishProduct() {
		CurrentProductPage currentProduct = loginOnSite().goToAccessoriesWatchPage()
											.selectProduct().addToWishList();
		return new Product(currentProduct.getBrand(), currentProduct.getPrice());
	}
	
	public WebDriver getDriver() {
		return this.driver;
	}
	
	@AfterClass
	public void quiteBrowser() {
		driver.navigate().refresh();
		driver.quit();
	}
}

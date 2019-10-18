package tests;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import WebDriver.DriverFactory;
import WebDriver.DriverType;
import pages.HomePage;

public class HomePageTest {
	
	WebDriver driver;
	HomePage homePage;
	
	@Before
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverType.CHROME);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("https://www.imdb.com/");
	}

	@After
	public void tearDown() throws Exception {
		driver.close();
	}

	@Test
	public void test() throws InterruptedException {
		homePage = PageFactory.initElements(driver, HomePage.class);
		assertEquals("Fail open home page.", "https://www.imdb.com/", driver.getCurrentUrl());
		Thread.sleep(3000);
	}

}

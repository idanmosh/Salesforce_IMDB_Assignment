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
import pages.SignInPage;
import pages.SignInTransitionPage;
import properties.LoadProperties;

public class SignInTest {
	
	WebDriver driver;
	HomePage homePage;
	SignInTransitionPage transPage;
	SignInPage signInPage;
	LoadProperties properties;

	@Before
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverType.CHROME);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("https://www.imdb.com/");
		properties = new LoadProperties(driver);
	}

	@After
	public void tearDown() throws Exception {
		driver.close();
	}

	@Test
	public void test() throws InterruptedException {
		homePage = PageFactory.initElements(driver, HomePage.class);
		assertEquals("Fail open home page.", "https://www.imdb.com/", driver.getCurrentUrl());
		homePage.ClickSignInBtn();
		
		transPage = PageFactory.initElements(driver, SignInTransitionPage.class);;
		assertTrue("Sign In with imdb button not displayed.", transPage.getSignInWithIMDbBtn().isDisplayed());
		transPage.ClickSignInWithImdbBtn();
		
		signInPage = PageFactory.initElements(driver, SignInPage.class);
		signInPage.signIn(properties.getEmail(), properties.getPassword());
		assertTrue("Failed to sign in.", homePage.getUsernameBar().isDisplayed());
		Thread.sleep(3000);
	}

}

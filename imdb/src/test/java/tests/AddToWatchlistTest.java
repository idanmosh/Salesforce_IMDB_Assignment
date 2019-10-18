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
import pages.SearchResultsPage;
import pages.SignInPage;
import pages.SignInTransitionPage;
import pages.TVShowPage;
import pages.YourWatchlistPage;
import properties.LoadProperties;

public class AddToWatchlistTest {

	WebDriver driver;
	HomePage homePage;
	SignInTransitionPage transPage;
	SignInPage signInPage;
	SearchResultsPage resultspage;
	TVShowPage tvShowPage;
	YourWatchlistPage watchlistPage;
	LoadProperties properties;
	
	@Before
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverType.CHROME);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
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
		assertTrue("Home page not found.", driver.getCurrentUrl().equals("https://www.imdb.com/"));
		System.out.println("Home page opened successfully.");
		homePage.ClickSignInBtn();
		
		transPage = PageFactory.initElements(driver, SignInTransitionPage.class);
		
		assertTrue("Sign In with imdb button not displayed.", transPage.getSignInWithIMDbBtn().isDisplayed());
		transPage.ClickSignInWithImdbBtn();
		
		signInPage = PageFactory.initElements(driver, SignInPage.class);
		signInPage.signIn(properties.getEmail(), properties.getPassword());
		assertTrue("Failed to sign in.", homePage.getUsernameBar().isDisplayed());
		
		for (int i = 0; i < properties.getTVShows().size(); i++) {
			homePage.getSearchBar().searchTVShow(properties.getTVShows().get(i).getName());
			resultspage = PageFactory.initElements(driver, SearchResultsPage.class);
			resultspage.pickResult(properties.getTVShows().get(i));
			tvShowPage = PageFactory.initElements(driver, TVShowPage.class);
			tvShowPage.check_if_add_to_watchList(properties.getTVShows().get(i), properties.getRating());
			homePage.returnToHomePage();
		}
		
		homePage.enterToWatchlist();
		watchlistPage = PageFactory.initElements(driver, YourWatchlistPage.class);
		assertTrue("Added Wrong tv shows into watch list.", watchlistPage.checkWatchlist(properties.getTVShows(), properties.getRating()));
		homePage.returnToHomePage();
		Thread.sleep(3000);
	}
}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import helper_classes.SearchBar;
/**
 * 
 * @author Idan Ben Moshe
 *
 */
public class HomePage extends PageObject {
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"imdb-signin-link\"]")
	private WebElement signInBtn;
	
	@FindBy(how = How.ID, using = "nbusername")
	private WebElement usernameBar;
	
	@FindBy(how = How.ID, using = "home_img")
	private WebElement homePageBtn;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"navWatchlistMenu\"]/p/a")
	private WebElement watchlistBtn;
	
	private SearchBar search;
	
	/**
	private By signInBtn_locator = By.xpath("//*[@id=\"imdb-signin-link\"]");
	private By usernameBar_locator = By.id("nbusername");
	private By homePageBtn_locator = By.id("home_img");
	private By watchlistBtn_locator = By.xpath("//*[@id=\"navWatchlistMenu\"]/p/a");
	**/
	
	/**
	 * Constructor.
	 * @param driver 
	 */
	public HomePage(WebDriver driver) {
		super(driver);
		search = PageFactory.initElements(driver, SearchBar.class);
	}
	
	/**
	 * Click on sign in button in home page.
	 */
	public void ClickSignInBtn() {
		signInBtn.click();
		//click(signInBtn_locator);
	}
	
	/**
	 * Get sign in button web element in home page.
	 * @return 
	 */
	public WebElement getSignInBtnLocator() {
		return signInBtn;
		//return findElement(signInBtn_locator);
	}
	
	/**
	 * Get user name bar web element in home page.
	 * @return
	 */
	public WebElement getUsernameBar() {
		return usernameBar;
		//return findElement(usernameBar_locator);
	}
	
	/**
	 * Get search bar web element in home page.
	 * @return
	 */
	public SearchBar getSearchBar() {
		return search;
	}
	
	/**
	 * Return to home Page.
	 */
	public void returnToHomePage() {
		homePageBtn.click();
		//click(homePageBtn_locator);
	}
	
	/**
	 * Enter to watch list from home page.
	 */
	public void enterToWatchlist() {
		watchlistBtn.click();
		//click(watchlistBtn_locator);
	}
}

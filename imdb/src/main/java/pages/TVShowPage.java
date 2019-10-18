package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import helper_classes.TVShow;
/**
 * 
 * @author Idan Ben Moshe
 *
 */
public class TVShowPage extends PageObject {

	@FindBy(how = How.CSS, using = "span[itemprop='ratingValue']")
	private WebElement tvShowPage_Rating;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"title-overview-widget\"]/div[1]/div[2]/div/div[2]/div[1]/div[1]/div")
	private WebElement addToWatchlistBtn;
	
	/**
	private By tvShowPage_Rating_locator = By.cssSelector("span[itemprop='ratingValue']");
	private By addToWatchlistBtn_locator = By.xpath("//*[@id=\"title-overview-widget\"]/div[1]/div[2]/div/div[2]/div[1]/div[1]/div"); 
	**/
	
	/**
	 * Constructor.
	 * @param driver
	 */
	public TVShowPage(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Check if add TV show to watch list or not.
	 * @param tvShow
	 * @param expectRating
	 */
	public void check_if_add_to_watchList(TVShow tvShow, float expectRating) {
		tvShow.setRating(Float.parseFloat(tvShowPage_Rating.getText()));
		
		if(tvShow.getRating() >= expectRating)
			addToWatchList(tvShow);
		else
			tvShow.setInWatchList(false);
	}
	
	/**
	 * Add TV show to watch list.
	 * @param tvShow
	 */
	public void addToWatchList(TVShow tvShow) {
		tvShow.setInWatchList(true);
		
		if(addToWatchlistBtn.getAttribute("title").contains("Click to add to watchlist"))
			addToWatchlistBtn.click();
	}
	
	/**
	 * Check if picked correct option from search results. 
	 * @return
	 */
	public boolean pickSuccess() {
		return addToWatchlistBtn.isDisplayed();
	}
}

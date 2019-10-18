package pages;

import java.util.List;

import org.openqa.selenium.By;
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
public class YourWatchlistPage extends PageObject {

	@FindBy(how = How.CSS, using = "div[class='lister-item-content']")
	private List<WebElement> watchlist;
	
	private By tvShowName_locator = By.cssSelector("h3[class='lister-item-header']");
	private By tvShowType_locator = By.xpath("p[1]/span[2]");
	private By tvShowRating_locator = By.cssSelector("div[class='ratings-imdb-rating']");
	
	/**
	private By watchlist_locator = By.cssSelector("div[class='lister-item-content']");
	
	**/
	
	/**
	 * Constructor.
	 * @param driver
	 */
	public YourWatchlistPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * Check if added only TV show with equal or greater rating from expected rating.
	 * @param tvShows
	 * @param expectRating
	 */
	public boolean checkWatchlist(List<TVShow> tvShows, float expectRating) {
		String name = null, type;
		float tvShow_rating = 0;
		boolean check = true;
		
		for (int i = 0; i < tvShows.size(); i++) {
			for (int j = 0; j < watchlist.size(); j++) {
				name = watchlist.get(j).findElement(tvShowName_locator).getText();
				type = watchlist.get(j).findElement(tvShowType_locator).getText();
				tvShow_rating = Float.parseFloat(watchlist.get(j).findElement(tvShowRating_locator).getText());
				
				if ((name.toLowerCase().contains(tvShows.get(i).getName().toLowerCase())) && 
						(type.toLowerCase().contains(tvShows.get(i).getType().toLowerCase()))) {
					if (tvShow_rating >= expectRating) {
						System.out.println("Succesfully added tv show " + name + " with rating " + 
								tvShow_rating + " that higher or equal from expected rating: " + expectRating + ".");
					}
					else
						check = false;
				}
			}
			if(!tvShows.get(i).getInWatchList())
				System.out.println("Fail added tv show " + tvShows.get(i).getName() + " with rating " + 
						tvShows.get(i).getRating() + " that lower from expected rating: " + expectRating + ".");
		}
		
		return check;
	}
	
}

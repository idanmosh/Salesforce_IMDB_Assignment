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
public class SearchResultsPage extends PageObject {
	
	@FindBy(how = How.CSS, using = "td[class='result_text']")
	private List<WebElement> searchResults;
	
	/**
	private By _locator = By.cssSelector("td[class='result_text']");
	private By resultElement_locator = By.tagName("a");
	**/
	
	/**
	 * Constructor.
	 * @param driver
	 */
	public SearchResultsPage(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Pick the most appropriate result from search results. 
	 * @param tvShow
	 */
	public void pickResult(TVShow tvShow) {
		
		for (int i = 0; i < searchResults.size(); i++) {
			if(MatchSearch(searchResults.get(i).getText(), tvShow.getName(), tvShow.getType())) {
				searchResults.get(i).findElement(By.tagName("a")).click();
				break;
			}
		}
	}
	
	/**
	 * Check if result appropriate to TV show.
	 * @param search_result
	 * @param TVShowName
	 * @param TVShowType
	 * @return
	 */
	public boolean MatchSearch(String search_result, String TVShowName, String TVShowType) {
		return (search_result.toLowerCase().contains(TVShowName.toLowerCase())) &&
				(search_result.toLowerCase().contains(TVShowType.toLowerCase()));
	}
	
	/**
	 * Checks if the TV show search was successful or not.
	 * @return
	 */
	public boolean searchSuccess() {
		return searchResults.isEmpty();
	}
}

package helper_classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import pages.PageObject;
/**
 * 
 * @author Idan Ben Moshe
 *
 */
public class SearchBar extends PageObject {

	@FindBy(how = How.XPATH, using = "//*[@id=\"quicksearch\"]")
	private WebElement selectTitles;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"navbar-query\"]")
	private WebElement searchTextBox;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"navbar-submit-button\"]")
	private WebElement searchBtn;
	
	/**
	private By selectTitles_locator = By.xpath("//*[@id=\"quicksearch\"]");
	private By searchTextBox_locator = By.xpath("//*[@id=\"navbar-query\"]");
	private By searchBtn_locator = By.xpath("//*[@id=\"navbar-submit-button\"]");
	**/
	
	public SearchBar(WebDriver driver) {
		super(driver);
	}

	public void searchTVShow(String tvShowName) {
		selectTitles();
		enterTVShowName(tvShowName);
		searchBtn.click();
		//click(searchBtn_locator);
	}
	
	public void selectTitles() {
		Select searchDropDown = new Select(selectTitles);
		searchDropDown.selectByVisibleText("Titles");
	}
	
	public void enterTVShowName(String tvShowName) {
		searchTextBox.clear();
		searchTextBox.sendKeys(tvShowName);
	}
}

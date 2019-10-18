package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
/**
 * 
 * @author Idan Ben Moshe
 *
 */
public class SignInTransitionPage extends PageObject {
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"signin-options\"]/div/div[1]/a[1]")
	private WebElement signInWithIMDbBtn;
	
	/**
	private By signInWithIMDb_locator = By.xpath("//*[@id=\"signin-options\"]/div/div[1]/a[1]");
	**/
	
	/**
	 * Constructor.
	 * @param driver
	 */
	public SignInTransitionPage(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Click on sign in with imdb button.
	 */
	public void ClickSignInWithImdbBtn() {
		signInWithIMDbBtn.click();
		//click(signInWithIMDb_locator);
	}

	/**
	 * Get sign in with imdb button web element by locator.
	 * @return
	 */
	public WebElement getSignInWithIMDbBtn() {
		return signInWithIMDbBtn;
		//return findElement(signInWithIMDb_locator);
	}
}

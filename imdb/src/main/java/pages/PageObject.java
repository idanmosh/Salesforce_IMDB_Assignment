package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
/**
 * 
 * @author Idan Ben Moshe
 *
 */
public abstract class PageObject {
	
	protected WebDriver driver;
	protected final String path = System.getProperty("user.dir");
	
	/**
	 * Constructor.
	 * @param driver
	 */
	public PageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
}

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
public class SignInPage extends PageObject {
	
	@FindBy(how = How.ID, using = "signInSubmit")
	private WebElement signInBtn;
	
	@FindBy(how = How.ID, using = "ap_email")
	private WebElement emailTextBox;
	
	@FindBy(how = How.ID, using = "ap_password")
	private WebElement passwordTextBox;
	
	/**
	private By signInBtn_locator = By.id("signInSubmit");
	private By emailTextBox_locator = By.id("ap_email");
	private By passwordTextBox_locator = By.id("ap_password");
	**/
	
	/**
	 * Constructor.
	 * @param driver
	 */
	public SignInPage(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Sign in into web site.
	 * @param email
	 * @param password
	 */
	public void signIn(String email, String password) {
		EnterEmail(email);
		EnterPassword(password);
		ClickSignIn();
	}
	
	/**
	 * Enter user email into email text box.
	 * @param email
	 */
	public void EnterEmail(String email) {
		emailTextBox.sendKeys(email);
		//type(email, emailTextBox_locator);
	}
	
	/**
	 * Enter user password into password text box.
	 * @param password
	 */
	public void EnterPassword(String password) {
		passwordTextBox.sendKeys(password);
		//type(password, passwordTextBox_locator);
	}
	
	/**
	 * Click on sign in button in sign in page.
	 */
	public void ClickSignIn() {
		signInBtn.click();
		//click(signInBtn_locator);
	}
	
	/**
	 * Get sign in page button web element by locator.
	 * @return
	 */
	public WebElement getSignInBtn() {
		return signInBtn;
		//return findElement(signInBtn_locator);
	}
	
	/**
	 * Get sign in page email text box web element by locator.
	 * @return
	 */
	public WebElement getEmailTextBox() {
		return emailTextBox;
		//return findElement(emailTextBox_locator);
	}
	
	/**
	 * Get sign in page password text box web element by locator.
	 * @return
	 */
	public WebElement getPasswordTextBox() {
		return passwordTextBox;
		//return findElement(passwordTextBox_locator);
	}
}

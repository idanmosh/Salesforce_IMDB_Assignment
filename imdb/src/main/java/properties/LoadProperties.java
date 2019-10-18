package properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import helper_classes.TVShow;
/**
 * 
 * @author Idan Ben Moshe
 *
 */
public class LoadProperties {

	final String path = System.getProperty("user.dir");
	private WebDriver driver;
	private String email;
	private String password;
	private List<TVShow> tvShows; 
	private float rating;
	
	/**
	 * Constructor.
	 * @param driver
	 */
	public LoadProperties(WebDriver driver) {
		this.driver = driver;
		tvShows = new ArrayList<TVShow>();
		loadProperties();
	}
	
	/**
	 * Insert TV shows into list.
	 * @param TVShowsNames
	 */
	public void InsertTVShows(String[] TVShowsNames) {
		TVShow TVshow;
		for (int i = 0; i < TVShowsNames.length; i++) {
			TVshow = new TVShow(TVShowsNames[i]);
			tvShows.add(TVshow);
			TVshow = null;
		}
	}
	
	/**
	 * Load all properties from properties files.
	 */
	public void loadProperties() {
		try {
			Properties SignInProp = new Properties();
			Properties TvShowsProp = new Properties();
			InputStream SignInInput = new FileInputStream(path + "/src/main/java/properties/SignIn.properties");
			InputStream TvShowsInput = new FileInputStream(path + "/src/main/java/properties/TVShowsList.properties");
			SignInProp.load(SignInInput);
			TvShowsProp.load(TvShowsInput);
			email = SignInProp.getProperty("email");
			password = SignInProp.getProperty("password");
			InsertTVShows(TvShowsProp.getProperty("tv").split(","));
			rating = Float.parseFloat(TvShowsProp.getProperty("ratings"));
			SignInInput.close();
			TvShowsInput.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
			driver.close();
		}
		catch (IOException e) {
			e.printStackTrace();
			driver.close();
		}
	}
	
	/**
	 * Get email.
	 * @return
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Get password.
	 * @return
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Get rating.
	 * @return
	 */
	public float getRating() {
		return rating;
	}
	
	/**
	 * Get all TV shows.
	 * @return
	 */
	public List<TVShow> getTVShows(){
		return tvShows;
	}
}

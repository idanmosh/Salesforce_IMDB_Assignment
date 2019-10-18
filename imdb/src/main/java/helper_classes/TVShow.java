package helper_classes;
/**
 * 
 * @author Idan Ben Moshe
 *
 */
public class TVShow {
	
	private String name;
	private float rating;
	private boolean inWatchList;
	private final String type = "TV Series"; 
	
	/**
	 * Constructor.
	 * @param name, TV Show name.
	 */
	public TVShow(String name) {
		this.name = name;
	}
	
	/**
	 * Get name of TV show.
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Get rating of TV show.
	 * @return
	 */
	public float getRating() {
		return rating;
	}
	
	/**
	 * Set TV show rating.
	 * @param rating
	 */
	public void setRating(float rating) {
		this.rating = rating;
	}
	
	/**
	 * Get if TV show added to watch list or not.
	 * @return
	 */
	public boolean getInWatchList() {
		return inWatchList;
	}
	
	/**
	 * Set if TV show added to watch list or not.
	 * @param inWatchList
	 */
	public void setInWatchList(boolean inWatchList) {
		this.inWatchList = inWatchList;
	}
	
	/**
	 * Get TV show type.
	 * @return
	 */
	public String getType() {
		return type;
	}
}

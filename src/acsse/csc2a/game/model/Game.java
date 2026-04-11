package acsse.csc2a.game.model;



public abstract class Game implements Comparable<Game> {

	private String title;
	private EGenre genre;
	private double rating; //0.0 to 10.0
	private EStatus status;
	
	/**
	 * Constructor to instantiate a Game object
	 * @param title The game's title
	 * @param genre The game's genre from EGenre
	 * @param rating The game's rating out of 10.0
	 */
	public Game(String title, EGenre genre, double rating) {
		this.title = title;
		this.genre = genre;
		this.rating = rating;
		this.status = EStatus.WISHLIST; //default status
	}
	
	public abstract String getDetails();
	
	/**
	 * provide a text representation of the game's details
	 * @return game's details
	 */
	@Override
	public String toString() {
		StringBuilder output = new StringBuilder();
		output.append("Title: " + title + "\n");
		output.append("Genre: " + genre + "\n");
		output.append("Rating: " + rating + "\n");
		output.append("Status: " + status.getDisplayLabel() + "\n");
		return output.toString();
	}
	
	/**
	 *override compareTo method.
	 *Sorts by rating and breaks ties using title names
	 */
	@Override
	public int compareTo(Game otherGame) {
		if (this.rating != otherGame.rating) {
			return Double.compare(otherGame.rating, this.rating);
		}
		
		return this.title.compareTo(otherGame.title);
	}
	
	//Accessor methods
	public String getTitle() {
		return title;
	}
	
	public EGenre getGenre() {
		return genre;
	}
	
	public double getRating() {
		return rating;
	}
	
	public EStatus getStatus() {
		return status;
	}
	
	//Mutator methods
	
	public void setTitle(String newTitle) {
		title = newTitle;
	}
	
	public void setGenre(EGenre newGenre) {
		genre = newGenre;
	}
	
	public void setRating(double newRating) {
		rating = newRating;
	}
	
	public void setStatus(EStatus newStatus) {
		status = newStatus;
	}
}

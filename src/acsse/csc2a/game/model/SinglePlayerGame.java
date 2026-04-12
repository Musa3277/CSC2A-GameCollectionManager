package acsse.csc2a.game.model;

/**
 * concrete subclass of Game. represents a single player game
 */
public class SinglePlayerGame extends Game {

	private static final long serialVersionUID = 1L;
			
	private double storyRating;
	
	/**
	 * @param title
	 * @param genre
	 * @param rating
	 * @param storyRating
	 */
	public SinglePlayerGame(String title, EGenre genre, double rating, double storyRating) {
		super(title, genre, rating);
		this.storyRating = storyRating;
	}

	//accesor methods
	
	public double getStoryRating() {
		return storyRating;
	}
	
	//mutator methods
	
	public void setStoryRating(double newRating) {
		storyRating = newRating;
	}
	
	@Override
	public String getDetails() {
		return "Single-Player | Story Rating: " + storyRating;
	}
	
	@Override
	public String toString() {
		return super.toString() + getDetails();
	}

}

/**
 * 
 */
package acsse.csc2a.game.model;

/**
 * concrete subclass of Game. represents a multiplayer game
 */
public class MultiplayerGame extends Game {

	private static final long serialVersionUID = 1L;
	
	private int maxPlayers;
	/**
	 * Constructor for multiplayer game object
	 * 
	 * @param title
	 * @param genre
	 * @param rating
	 */
	public MultiplayerGame(String title, EGenre genre, double rating, int maxPlayers) {
		super(title, genre, rating);
		this.maxPlayers = maxPlayers;
	}

	//accessor methods
	public int getMaxPlayers() {
		return maxPlayers;
	}
	
	//mutator methods
	public void setMaxPlayers(int newMaxPlayers) {
		this.maxPlayers = newMaxPlayers;
	}

	
	@Override
	public String getDetails() {
		return "Multi-Player | Max Players: " + maxPlayers;
	}
	
	@Override
	public String toString() {
		return super.toString() + getDetails();
	}

}

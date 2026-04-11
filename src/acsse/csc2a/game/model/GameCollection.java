package acsse.csc2a.game.model;

import java.util.ArrayList;

/**
 * Represents the collection of Game objects
 */
public class GameCollection {

	private ArrayList<Game> games;
	/**
	 * constructor to instatiate the collection of games object
	 * @param games list of games
	 */
	public GameCollection(ArrayList<Game> games) {
		this.games = games;
	}
	
	//accessor
	public ArrayList<Game> getGames(){
		return games;
	}
	
	/**
	 * Add a game to the array list
	 * @param newGame
	 */
	public void addGame(Game newGame) {
		games.add(newGame);
	}
	
	/**
	 * retrieve a game from the list
	 * @param index
	 * @return
	 */
	public Game getGame(int index) {
		return games.get(index);
	}
	
	/**
	 * retrieve the number of games currently in the collection
	 * @return number of games
	 */
	public int getNumGames() {
		return games.size();
	}
	
	public void displayCollection() {
		for (Game thisGame : games) {
			System.out.println(thisGame.toString());
		}
	}
	
}

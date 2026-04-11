package acsse.csc2a.game.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

import acsse.csc2a.game.model.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * file handler to read and write files
 */
public class GameTextFileHandler {

	/**
	 * constructor to instatiate a new file handler object
	 */
	public GameTextFileHandler() {
		
	}

	/**
	 * read a file with a list of games and create a collection
	 * @param handle location of file
	 * @return myCollection collection of games
	 */
	public static GameCollection readCollection(File handle) {
		
		GameCollection myCollection = new GameCollection();
		String basePattern = "[A-Z]{2}\\d{4}\\t.+\\t(ACTION|FIRST_PERSON_SHOOTER|RACING|RPG|SIMULATION|SPORTS|STRATEGY)\\t(\\d+[\\.]\\d+)\\t";
		Pattern spPattern = Pattern.compile(basePattern + "SP\\t\\d+[\\.]\\d+");
		Pattern mpPattern = Pattern.compile(basePattern + "MP\\t\\d+");
		
		String gameID;
		String title;
		EGenre genre;
		double rating;
		String type;
		double storyRating;
		int maxPlayers;
		try(Scanner txtIn = new Scanner(handle)){
			while (txtIn.hasNextLine()) {
				String line = txtIn.nextLine();
				if (spPattern.matcher(line).matches()) {
					
					SinglePlayerGame spGame;
					StringTokenizer spTokenizer = new StringTokenizer(line, "\t");
					gameID = spTokenizer.nextToken();
					title = spTokenizer.nextToken();
					genre = EGenre.valueOf(spTokenizer.nextToken());
					rating = Double.parseDouble(spTokenizer.nextToken());
					type = spTokenizer.nextToken();
					storyRating = Double.parseDouble(spTokenizer.nextToken());
	
					spGame = new SinglePlayerGame(title, genre, rating, storyRating);
					myCollection.addGame(spGame);
				} else if (mpPattern.matcher(line).matches()){
					MultiplayerGame mpGame;
					StringTokenizer mpTokenizer = new StringTokenizer(line, "\t");
					gameID = mpTokenizer.nextToken();
					title = mpTokenizer.nextToken();
					genre = EGenre.valueOf(mpTokenizer.nextToken());
					rating = Double.parseDouble(mpTokenizer.nextToken());
					type = mpTokenizer.nextToken(); 
					maxPlayers = Integer.parseInt(mpTokenizer.nextToken());
					
					mpGame = new MultiplayerGame(title, genre, rating, maxPlayers);
					myCollection.addGame(mpGame);
				} else {
					System.out.println("Rejected Line: " + line);
				}
			}
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}
		
		return myCollection;
	}
}

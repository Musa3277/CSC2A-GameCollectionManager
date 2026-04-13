package acsse.csc2a.game.main;
import acsse.csc2a.game.model.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

import acsse.csc2a.game.file.GameTextFileHandler;
import acsse.csc2a.game.file.GameBinaryFileHandler;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("---PHASE 1---");

		GameCollection myCollection = new GameCollection();
		
		SinglePlayerGame testGame1 = new SinglePlayerGame("game 1", EGenre.ACTION, 5.5, 6.7);
		MultiplayerGame testGame2 = new MultiplayerGame("game 2", EGenre.RACING, 8.9, 20);
		
		myCollection.addGame(testGame1);
		myCollection.addGame(testGame2);
		myCollection.displayCollection();
		
		for (int i = 0; i < myCollection.getNumGames(); i++) {
			
			Game thisGame = myCollection.getGame(i);
			if (thisGame instanceof SinglePlayerGame) {
				SinglePlayerGame mySoloGame = (SinglePlayerGame) thisGame;
				System.out.println(mySoloGame.getTitle() + " Story rating: " + mySoloGame.getStoryRating());
			}
			
			if (thisGame instanceof MultiplayerGame) {
				MultiplayerGame myFriendlyGame = (MultiplayerGame) thisGame;
				System.out.println(myFriendlyGame.getTitle() + " max players: " + myFriendlyGame.getMaxPlayers());
			}
		}
		
		for (EStatus myStatus : EStatus.values()) {
			System.out.println(myStatus.name());
			System.out.println(myStatus.getDisplayLabel());
			System.out.println(myStatus.getColourHex());
		}
		
		System.out.println("---PHASE 2---");
		File inputFile = new File("data/games-small.txt");
		GameCollection myCollection2;
		myCollection2 = GameTextFileHandler.readCollection(inputFile);
		myCollection2.displayCollection();
		
		System.out.println("---PHASE 3---");
		Collections.sort(myCollection2.getGames());
		myCollection2.displayCollection();
		
		System.out.println();
		System.out.println("---PHASE 4---");
		GameBinaryFileHandler.writeGameDataFile(new File("data/games.dat"), myCollection2.getGames());
		
		ArrayList<Game> games = GameBinaryFileHandler.readGameDataFile(new File("data/games.dat"));
		for (Game myGame : games) {
			if (myGame instanceof SinglePlayerGame) {
				SinglePlayerGame spGame = (SinglePlayerGame) myGame;
				System.out.println(spGame);
			} else if (myGame instanceof MultiplayerGame) {
				MultiplayerGame mpGame = (MultiplayerGame) myGame;
				System.out.println(mpGame);
			}
		}
		
		System.out.println();
		
		Collections.sort(games);
		for (Game myGame : games) {
			if (myGame instanceof SinglePlayerGame) {
				SinglePlayerGame spGame = (SinglePlayerGame) myGame;
				System.out.println(spGame);
			} else if (myGame instanceof MultiplayerGame) {
				MultiplayerGame mpGame = (MultiplayerGame) myGame;
				System.out.println(mpGame);
			}
		}
		
	}

}

package acsse.csc2a.game.main;
import acsse.csc2a.game.model.*;

import java.io.File;

import acsse.csc2a.game.file.GameTextFileHandler;

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
	}

}

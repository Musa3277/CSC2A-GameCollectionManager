package acsse.csc2a.game.file;

import acsse.csc2a.game.model.*;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class GameBinaryFileHandler {

	public GameBinaryFileHandler() {
		
	}
	
	public static void writeGameDataFile(File handle, ArrayList<Game> games) {
		

		try (FileOutputStream fos = new FileOutputStream(handle);
			 BufferedOutputStream bos = new BufferedOutputStream(fos);
			 DataOutputStream dos = new DataOutputStream(bos);){
			
		dos.writeInt(games.size());
		for (Game thisGame : games) {
			dos.writeUTF(thisGame.getTitle());
			dos.writeUTF(thisGame.getGenre().name());
			dos.writeDouble(thisGame.getRating());
			dos.writeUTF(thisGame.getStatus().name());
			if (thisGame instanceof SinglePlayerGame) {
				SinglePlayerGame spg = (SinglePlayerGame) thisGame;
				dos.writeUTF("SP");
				dos.writeDouble(spg.getStoryRating());
			} else if (thisGame instanceof MultiplayerGame) {
				MultiplayerGame mpg = (MultiplayerGame) thisGame;
				dos.writeUTF("MP");
				dos.writeInt(mpg.getMaxPlayers());
				
			}
			
		}
			
			
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public static ArrayList<Game> readGameDataFile(File handle) {
		
		ArrayList<Game> games = new ArrayList<>();
		
		try (FileInputStream fis = new FileInputStream(handle);
			 BufferedInputStream bis = new BufferedInputStream(fis);
			 DataInputStream dis = new DataInputStream(bis);){
			
			int gameCount = dis.readInt();
			String title;
			EGenre genre;
			double rating;
			EStatus status;
			String type;
			double storyRating;
			int maxPlayers;
			
			for (int i = 0; i < gameCount; i++){
				title = dis.readUTF();
				genre = EGenre.valueOf(dis.readUTF());
				rating = dis.readDouble();
				status = EStatus.valueOf(dis.readUTF());
				type = dis.readUTF();
				
				if (type == "SP") {
					storyRating = dis.readInt();
					SinglePlayerGame spGame = new SinglePlayerGame(title, genre, rating, storyRating);
					spGame.setStatus(status);
					games.add(spGame);
				} else if (type == "MP") {
					maxPlayers = dis.readInt();
					MultiplayerGame mpGame = new MultiplayerGame(title, genre, rating, maxPlayers);
					mpGame.setStatus(status);
					games.add(mpGame);
				}
			}
			
			return games;
		} 
		catch (IOException ex) {
			ex.printStackTrace();
		}
		
		return null;
	}
}
	

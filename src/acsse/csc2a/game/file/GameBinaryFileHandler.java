package acsse.csc2a.game.file;

import acsse.csc2a.game.model.*;

import java.io.File;
import java.util.ArrayList;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.BufferedOutputStream;
import java.io.ObjectOutputStream;


public class GameBinaryFileHandler {

	public GameBinaryFileHandler() {
		
	}
	
	public static void writeGameDataFile(File handle, ArrayList<Game> games) {
		

		try (FileOutputStream fos = new FileOutputStream(handle);
			 BufferedOutputStream bos = new BufferedOutputStream(fos);
			 ObjectOutputStream oos = new ObjectOutputStream(bos);){
			
		oos.writeInt(games.size());
		for (Game thisGame : games) {
			oos.writeUTF(thisGame.getTitle());
			oos.writeUTF(thisGame.getGenre().name());
			oos.writeDouble(thisGame.getRating());
			oos.writeUTF(thisGame.getStatus().name());
			if (thisGame instanceof SinglePlayerGame) {
				oos.writeUTF("SP");
			} else if (thisGame instanceof MultiplayerGame) {
				oos.writeUTF("MP");
			}
			
		}
			
			
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
	

package game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import board.*;

public class BoardLoader {
	
	public Board Load(String path) throws IOException {
		/**
		 * Returns a board represented by the file located at path
		 * 
		 * @Throws an IOException if the file is improperly formated
		 */
		HashMap<Location, Cell> InitialCells = new HashMap<Location,Cell>();
		AliveCell ALIVE = new AliveCell();
		try (BufferedReader inputstream = new BufferedReader(new FileReader(path))){
			String Line;
			
			while ((Line = inputstream.readLine()) != null){
				
					InitialCells.put(Parser(Line), ALIVE);
				
			}
			
			return new Board(InitialCells);
		}
		
		
	}
	
	public Location Parser(String s) throws IOException {
		
		String[] parsed = s.split(",");
		try{
			return new Location(Integer.parseInt(parsed[0]), Integer.parseInt(parsed[1]));
		}
		catch (Exception e){
			throw new IOException("Improper Format of line" + s);
		}
		
	}

}

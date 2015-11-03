package game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import display.Display;
import board.*;
public class Main {

	public static void main(String[] args) throws IOException, OverPopulationException{
		String path = args[0];
		String lineread;
		BoardLoader BL = new BoardLoader();
		Display BD = new Display(new Location(-100,-30), new Location(-100,50), new Location(100,-30));
		Board B = BL.Load(path);
		
		BD.PrintBoard(B);
		System.out.println("\n\nEnter q to quit, otherwise press enter:\n\n");
		try(BufferedReader cin = new BufferedReader(new InputStreamReader(System.in))){
			while (!(lineread = cin.readLine()).equals("q")){
				B = B.NextGeneration();
				BD.PrintBoard(B);
				System.out.println("\n\nEnter q to quit, otherwise press enter:\n\n");
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		return;
		
		
	}
}

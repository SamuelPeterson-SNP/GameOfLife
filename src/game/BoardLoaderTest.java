package game;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.HashMap;

import org.junit.Test;

import board.*;



public class BoardLoaderTest {
	BoardLoader BL = new BoardLoader();
	public HashMap<Location,Cell> InitialCells;
	AliveCell ALIVE = new AliveCell();
	DeadCell DEAD = new DeadCell();
	
	@Test
	public void LoadTest() {
		// Test Case 1: Test for equality.  Given a file represented by Glider.gol, which is an alive cell 
		
		InitialCells = new HashMap<Location,Cell>();
		InitialCells.put(new Location(0,0), ALIVE);
		InitialCells.put(new Location(-1,1),ALIVE);
		InitialCells.put(new Location(1,0), ALIVE);
		InitialCells.put(new Location(1,1), ALIVE);
		InitialCells.put(new Location(1,2), ALIVE);
		Board ExpectedBoard = new Board(InitialCells);
		
		Board ActualBoard;
		try {
			
			ActualBoard = BL.Load("/home/samuel/workspace/GameOfLife/src/test_cases/glider.gol");
			assertEquals(ActualBoard, ExpectedBoard);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
		
		
		
		
	}
	
	@Test
	public void ParserTest() {
		
		
		Location ActualLocation;
		try {
			ActualLocation = BL.Parser("5,3");
			Location ExpectedLocation = new Location(5,3);
			assertEquals(ExpectedLocation, ActualLocation);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
		
	}

}

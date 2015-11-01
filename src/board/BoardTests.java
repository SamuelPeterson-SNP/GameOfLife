package board;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class BoardTests {
	Board board = new Board();
	@Test
	public void TallyTest() {
		
		
		ArrayList<Cell> neighbors = new ArrayList<Cell>();
		int tally;
		
		// First Test Case count 0 alive neighbors given 0 neighbors, and 2 neighbors.
		tally = board.CountTally(neighbors);
		assertEquals(0,tally);
		
		
		neighbors.add(new DeadCell());
		neighbors.add(new DeadCell());
		tally = board.CountTally(neighbors);
		assertEquals(0,tally);
		
		
		// Second Test Case count 1 alive neighbors in a list of 1 and 3 neighbors.
		neighbors = new ArrayList<Cell>();
		neighbors.add(new AliveCell());
		tally = board.CountTally(neighbors);
		assertEquals(1,tally);
		
		neighbors.add(new DeadCell());
		neighbors.add(new DeadCell());
		tally = board.CountTally(neighbors);
		assertEquals(1,tally);
		
		// Third Test count 2 alive neighbors in a list of 4 neighbors.
		neighbors.add(new AliveCell());
		tally = board.CountTally(neighbors);
		assertEquals(2,tally);
		
	}
	
	@Test
	public void NeighborPollTest() {
		// Tests the output of Cell.Poll() method
		Cell vote;
		
		//First Test.  check that DeadCell.Poll() == 0
		vote = new DeadCell();
		int deadvote = vote.Poll();
		assertEquals(0, deadvote);
		
		//Second Test.  Check that AliveCell.Poll() == 1
		vote = new AliveCell();
		int alivevote = vote.Poll();
		assertEquals(1,alivevote);
	}
	
	@Test
	public void LocationTest(){
		
		Location L = new Location(3,1);
		
		assertTrue( L.equals(new Location(3,1)));
		
		ArrayList<Location> neighbors = L.GetNeighborLocations();
		ArrayList<Location> testlocations = new ArrayList<Location>();
		testlocations.add(new Location(4,1));
		testlocations.add(new Location(4,2));
		testlocations.add(new Location(3,2));
		testlocations.add(new Location(2,2));
		testlocations.add(new Location(2,1));
		testlocations.add(new Location(2,0));
		testlocations.add(new Location(3,0));
		testlocations.add(new Location(4,0));
		
		
		
		assertEquals(neighbors, testlocations);
		
		
		
	}
	
	@Test
	public void AddCellTest(){
		Board B = new Board();
		try{
			B.AddCell(new AliveCell(), new Location(1,1));
		}
		catch(AddCellException e){
			fail("This Cell should be addable");
		}
		try {
			B.AddCell(new DeadCell(), new Location(1,1));
			fail("Cell shouldn't have been addable");
		}
		catch (AddCellException e){
			System.out.println(e.getMessage());
			System.out.println("Great Catch for the exception!");
		}
		
		try{
			B.AddCell(new AliveCell(), new Location(1,2));
		}
		catch (AddCellException e){
			fail("This Cell should be addable");
		}
		try{
			B.AddCell(new AliveCell(), new Location(2,1));
		}
		catch (AddCellException e){
			fail("This Cell should be addable");
		}
	}
	
	public void CellEqualityTest(){
		AliveCell a = new AliveCell();
		AliveCell b = new AliveCell();
		DeadCell c = new DeadCell();
		DeadCell d = new DeadCell();
		
		assertTrue(a.equals(b));
		assertTrue(a.equals(a));
		assertTrue(c.equals(d));
		assertTrue(d.equals(d));
		assertFalse(b.equals(c));
	}
	
	@Test
	public void NeighborCensusTest(){
		Board B = new Board();
		ArrayList<Cell> list;
		
		Location L;
		// Tests the method Board.Census(Cell) which returns a list of neighbors of Cell.
		
		//Test 1 Returns neighbors of a Cell with no neighbors
		list = new ArrayList<Cell>();
		try{
		B.AddCell(new AliveCell(), new Location(1,1));
		}
		catch (AddCellException e){
			fail();
		}
		L = new Location(1,1);
		assertEquals(list,B.Census(L));
		
		try{
			B.AddCell(new DeadCell(), new Location(4,5));
		}
		catch(AddCellException e){
			fail();
		}
		
		
		// Test 2: Returns neighbors of a Cell with 1 neighbors
		list.add(new DeadCell());
		try{
			B.AddCell(new DeadCell(), new Location(2,2));
		}
		catch(AddCellException e){
			fail();
		}
		assertEquals(list,B.Census(L));
		
		
		// Test 3: Returns neighbors of a Cell with 2 neighbors
		
		list.add(0, new AliveCell());
		try{
			B.AddCell(new AliveCell(), new Location(2,1));
		}
		catch(AddCellException e){
			fail();
		}
		assertEquals(list,B.Census(L));
		
	}

	@Test
	public void TestCellConstructor(){
		
		Cell cell1 = new DeadCell();
		Cell cell2 = new DeadCell();
		Cell cell3 = new AliveCell();
		Cell cell4 = new AliveCell();
		
		assertEquals(cell1,cell2);
		assertEquals(cell3,cell4);
		assertFalse(cell2.equals(cell3));
		
		
		
		
	}

	@Test
	public void TestCellFuture(){
		boolean alive;
		Cell a = new DeadCell();
		Cell b = new AliveCell();
		
		//Test 1: See if a Cell is born with 0,1,2,3,4 neighbors
		
		alive = a.AliveInFuture(0);
		assertFalse(alive);
		alive = a.AliveInFuture(1);
		assertFalse(alive);
		alive = a.AliveInFuture(2);
		assertFalse(alive);
		alive = a.AliveInFuture(3);
		assertTrue(alive);
		alive = a.AliveInFuture(4);
		assertFalse(alive);
		
		//Test 2 See if a Cell survives with 0,1,2,3,4 neighbors
		
		alive = b.AliveInFuture(0);
		assertFalse(alive);
		alive = b.AliveInFuture(1);
		assertFalse(alive);
		alive = b.AliveInFuture(2);
		assertTrue(alive);
		alive = b.AliveInFuture(3);
		assertTrue(alive);
		alive = b.AliveInFuture(4);
		assertFalse(alive);
		
	}

	
	
	@Test
	public void TestNewBoardGeneration() throws Exception{
		Board B = new Board();
		Board test;
		
		//Test 1 EmptyBoard Should generate an empty Board
		test = B.NextGeneration();
		assertEquals(B,test);
		
		//Test 2 DeadCells Should Be cleared
		try{
			B.AddCell(new DeadCell(), new Location(1,1));
		}
		catch(AddCellException e){
			fail();
		}
		test = B.NextGeneration();
		B = new Board();
		assertEquals(test, B);
		
		
		//Test 3 Three in a Diagonal Test
		B.AddCell(new AliveCell(), new Location(0,0));
		B.AddCell(new AliveCell(), new Location(1,1));
		B.AddCell(new AliveCell(), new Location(2,2));
		
		test = B.NextGeneration();
		B = new Board();
		B.AddCell(new AliveCell(), new Location(1,1));
		B.AddCell(new DeadCell(), new Location(2,1));
		B.AddCell(new DeadCell(), new Location(2,2));
		B.AddCell(new DeadCell(), new Location(1,2));
		B.AddCell(new DeadCell(), new Location(0,2));
		B.AddCell(new DeadCell(), new Location(0,1));
		B.AddCell(new DeadCell(), new Location(0,0));
		B.AddCell(new DeadCell(), new Location(1,0));
		B.AddCell(new DeadCell(), new Location(2,0));
		assertEquals(test,B);
		
	}

	
	
}

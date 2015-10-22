package board;

import java.util.ArrayList;
import java.util.HashMap;

public class Board {
	/**
	 * Board Contains the state of the Game at a given point in time.
	 * The Cells are represented as a HashMap<Location, Cell> object.
	 * 
	 * A Board can be instantiated with no argument or with a HashMap<Location,Cell> object
	 * With no argument, the Board is Generated with an empty cells field
	 * With A HashMap<Location,Cell> object in the constructor, this.cells is a shallow copy of the 
	 * object that is passed to the constructor
	 */
	private HashMap<Location,Cell> cells;
	
	
	public Board(){
		cells = new HashMap<Location,Cell>();
	}
	
	public Board(HashMap<Location,Cell> cells){
		this.cells = new HashMap<Location,Cell>(cells);
	}
	
	
	public int CountTally(ArrayList<Cell> neighbors) {
		/**
		 *  Returns the number of elements in the array neighbors that are of the class AliveCell
		 */
		int ret = 0;
		for (Cell c : neighbors){
			ret += c.Poll();
		}
		return ret;
	}

	public void AddCell(Cell cell) throws AddCellException {
		/**
		 * Adds the Cell cell to the Map at the location of cell.GetLocation().
		 * Can only add a cell to a location that has not been mapped already.
		 * I.E You cannot overwrite an existing cell. 
		 */
		if (!cells.containsKey(cell.GetLocation())){
			cells.put(cell.GetLocation(), cell);
		}
		else{
			throw new AddCellException("Shouldn't be able to add cell.  Location is already occupied");
		}
		
		
	}

	
	
	
 	public ArrayList<Cell> Census(Location l) {
		/**
		 * Returns an array of Cell objects from this.cells which neighbor the Location l
		 */
 		
 		ArrayList<Cell> ret = new ArrayList<Cell>();
		
		for (Location neighbor : l.GetNeighborLocations()){
			if (cells.containsKey(neighbor)){
				ret.add(cells.get(neighbor));
			}
		}
		
		return ret;
	}

	public boolean equals(Board other){
		/**
		 * Returns true is this.cells has the same mappings as other.cells
		 */
		return this.cells.equals(other.cells);
	}
	
	@Override public boolean equals(Object other){
		/**
		 * equals override so that Boards in an iterable can be compared with equals
		 */
		if (other instanceof Board){
			Board that = (Board) other;
			return this.equals(that);
		}
		return false;
	}

	public Board NextGeneration() throws OverPopulationException {
		/**
		 * Returns a new Board instance which represents the next generation 
		 * in accordance with the rules of the Game Of Life.
		 * 
		 * @Exceptions: If the next generation has 1000000 or more alive cells, throws an OverPopulation Exception 
		 */
		int PopulationCap = 1000000;
		
		HashMap<Location,Cell> AliveBoard = new HashMap<Location,Cell>();
		HashMap<Location,Cell> returnBoard;
		int tally;
		
		for (Location l : this.cells.keySet()){
			tally = this.CountTally(this.Census(l));
			if (this.cells.get(l).AliveInFuture(tally)){
				AliveBoard.put(l, new AliveCell(l));
				if (AliveBoard.size() >= PopulationCap){
					throw new OverPopulationException("Board is too Crowded");
				}
			}
		}
		
		returnBoard = new HashMap<Location,Cell>(AliveBoard);
		
		for (Location l : AliveBoard.keySet()){
			for (Location i : l.GetNeighborLocations()){
				if (!returnBoard.containsKey(i)) returnBoard.put(i, new DeadCell(i));
			}
		}
		
		
		return new Board(returnBoard);
	}

	
	public Cell GetCell(Location L){
		/**
		 * Returns Cell that lives in location L if it exists in this.cells
		 * otherwise, returns the Arbitrary DeadCell: new DeadCell(1,1)
		 */
		if (cells.containsKey(L)){
			return cells.get(L);
		}
		return new DeadCell(L);
	}
	
	
	public boolean IsAlive(){
	/**
	 * Returns true if cells has any Alive nodes, otherwise, returns false	
	 */
		return cells.containsValue(new AliveCell(1,1));
	}
}

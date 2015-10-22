package board;

import rules.Rules;

public class Cell {
	/**
	 * Cell Object.  Specifically instantiated by AliveCell and DeadCell in this particular Project.
	 * Contains a Rules.
	 * 
	 * Design Flaw:  Cell should not have a location field.  Will correct that in next version.  Location of
	 * Cell should be managed solely in the Board Field.
	 */
	private Location location;
	Rules rule = new Rules();
	
	public Cell(int XCoord,int YCoord){
		this.location = new Location(XCoord,YCoord);
	}
	public Cell(Location L){
		this.location = L;
	}
	
	
	public int Poll() {
		// returns 0
		return 0;
	}

	

	public Location GetLocation() {
		return this.location;
	}
	public boolean AliveInFuture(int i) {
		
		return false;
	}
	
	public String DisplayToken(){
		return "";
	}

}

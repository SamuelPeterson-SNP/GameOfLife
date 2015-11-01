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
	
	Rules rule = new Rules();
	
	public Cell(){
		
	}
	
	
	
	public int Poll() {
		// returns 0
		return 0;
	}

	

	
	public boolean AliveInFuture(int i) {
		
		return false;
	}
	
	public String DisplayToken(){
		return "";
	}

}

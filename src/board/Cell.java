package board;

import rules.Rules;

public class Cell {
	/**
	 * Cell Object.  Specifically instantiated by AliveCell and DeadCell in this particular Project.
	 * Contains a Rules.
	
	
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

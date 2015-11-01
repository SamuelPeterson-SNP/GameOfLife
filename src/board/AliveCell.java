package board;


public class AliveCell extends Cell {
	
	public AliveCell(){
		
	}
	

	
	
	public boolean AliveInFuture(int count){
		/**
		 * Returns whether Cell remains alive given it has count neighbors according to the Rules object.
		 */
		return rule.SurvivalRule(count);
	}
	
	@Override public boolean equals(Object other){
		return other instanceof AliveCell;
	}
	
 	public int Poll() {

		/**
		 * Returns 1
		 */
		return 1;
	}
	
	public String DisplayToken(){
		/**
		 * Returns "A"
		 */
		return "A";
	}
	
}

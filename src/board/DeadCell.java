package board;



public class DeadCell extends Cell {
	
	
	
	public DeadCell() {
		

	}
	
	@Override public boolean equals(Object other){
		return other instanceof DeadCell;
	}
	
	public boolean AliveInFuture(int count){
		/**
		 * Returns whether Cell is Born given it has count neighbors according to the Rule Object.
		 */
		return rule.BirthRule(count);
	}
	
	

	public int Poll(){
		/**
		 * Returns 0
		 */
		return 0;
	}
	
	public String DisplayToken(){
		/**
		 * Returns "_"
		 */
		return "_";
	}
}

package board;



public class DeadCell extends Cell {
	
	
	
	public DeadCell(int XCoord, int YCoord) {
		super(XCoord, YCoord);

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
	
	public DeadCell(Location L){
		super(L);
	}

	public int Poll(){
		/**
		 * Returns 0
		 */
		return 0;
	}
	
	public String DisplayToken(){
		/**
		 * Returns "D"
		 */
		return "D";
	}
}

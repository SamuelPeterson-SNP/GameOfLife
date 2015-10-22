package rules;

public class Rules {
	
	public boolean SurvivalRule(int neighbors){
		/**
		 * SurvivalRule: returns false when neighbors < 2 or neighbors > 3, otherwise returns true
		 */
		return neighbors < 4 && neighbors > 1;
	}

	public boolean BirthRule(int neighbors) {
		/**
		 * BirthRule: returns true when neighbors == 3, otherwise returns false
		 */
		return neighbors == 3;
	}
}

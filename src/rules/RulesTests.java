package rules;

import static org.junit.Assert.*;

import org.junit.Test;

public class RulesTests {
	Rules rules = new Rules();
	@Test
	public void SurvivalTest() {
		assertFalse(rules.SurvivalRule(4));
		assertTrue(rules.SurvivalRule(3));
		assertFalse(rules.SurvivalRule(1));
		assertFalse(rules.SurvivalRule(0));
		assertTrue(rules.SurvivalRule(2));
	}
	
	@Test
	public void BirthRuleTest() {
		boolean Birth;
		Birth = rules.BirthRule(0);
		assertFalse(Birth);
		
		Birth = rules.BirthRule(2);
		assertFalse(Birth);
		
		Birth = rules.BirthRule(3);
		assertTrue(Birth);
		
		Birth = rules.BirthRule(4);
		assertFalse(Birth);
	}
	
	

}

package display;
import board.*;

import static org.junit.Assert.*;

import org.junit.Test;

public class DisplayTest {

	@Test
	public void test() throws ImproperDimensionException, AddCellException {
		Display D = new Display(new Location(0,0), new Location(0,3), new Location(2,0));
		String actual;
		String expected;
		Board B = new Board();
		B.AddCell(new AliveCell(), new Location(1,1));
		
		
		actual = D.GetBoardString(B);
		expected = "\nDDD\nDDD\nDAD\nDDD\n";
		
		System.out.println(actual);
		System.out.println(expected);
		assertEquals(actual,expected);
	}

}

package display;
import board.*;

public class Display {

	// Rep Invariant: lowerleft.XCoord == upperleft.XCoord < lowerright.XCoord
	// Rep Invariant: lowerleft.YCoord == lowerright.YCoord < upperleft.YCoord
	Location lowerleft;
	Location upperleft;
	Location lowerright;
	
	public Display(Location ll, Location ul, Location lr) {
		this.lowerleft = ll;
		this.upperleft = ul;
		this.lowerright = lr;
		
		
	}
	
	public void CheckInvariant() throws ImproperDimensionException{
		if (lowerleft.GetXCoord() != upperleft.GetXCoord() || upperleft.GetXCoord() >= lowerright.GetXCoord()){
			throw new ImproperDimensionException("X Coordinates are inconsistant.");
		}
		if (lowerleft.GetYCoord() >= upperleft.GetYCoord() || lowerleft.GetYCoord() != lowerright.GetYCoord()){
			throw new ImproperDimensionException("Y Coordinates are inconsistant.");
		}
	}

	public String GetBoardString(Board B) {
		int XDim, YDim;
		String ret = "\n";
		XDim = lowerright.GetXCoord() - lowerleft.GetXCoord();
		YDim = upperleft.GetYCoord() - lowerleft.GetYCoord();
		
		for (int y = 0; y <= YDim; y++){
			for (int x = 0; x <= XDim; x++){
				ret = ret + B.GetCell(new Location(upperleft.GetXCoord() + x, upperleft.GetYCoord() - y)).DisplayToken();
			}
			ret = ret + "\n";
		}
		
		return ret;
	}
	
	public void PrintBoard(Board B){
		System.out.println(GetBoardString(B));
	}
}

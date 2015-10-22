package board;

import java.util.ArrayList;

public class Location extends Object{
	/**
	 * Location object.  Contains an XCoord and a YCoord, both of which are integers
	 */
	private int XCoord, YCoord;
	
	public Location(int x, int y){
		/**
		 * Sets this.XCoord to x and this.YCoord to y
		 */
		XCoord = x;
		YCoord = y;
	}
	
	@Override public boolean equals(Object other){
		/**
		 * Override so that Locations can be compared with the equals method in an iterator
		 */
		if (other instanceof Location){
			Location that = (Location) other;
			return equals(that);
		}
		return false;
	}
	
	@Override public int hashCode(){
		/**
		 * Override For hash Code.  This exists so that the HashCode of a Location depends solely on the XCoord and YCoord values.
		 */
		return 41*(41 + GetXCoord()) + GetYCoord();
	}
	
	public boolean equals(Location L){
		/**
		 * Two locations are equal if their XCoord and YCoord fields are equal
		 */
		return L.GetXCoord() == this.XCoord && L.GetYCoord() == this.YCoord;
	}
	
	
	public int GetXCoord(){
		/**
		 * Returns this.XCoord
		 */
		return this.XCoord;
	}
	
	public int GetYCoord(){
		/**
		 * Returns this.YCoord
		 */
		return this.YCoord;
	}


	public ArrayList<Location> GetNeighborLocations() {
		/**
		 * Returns an ArrayList of Adjacent Locations.  Order is in CounterClockwise order starting at 3 O'Clock
		 */
		ArrayList<Location> ret = new ArrayList<Location>();
		ret.add(new Location(this.XCoord + 1, this.YCoord + 0));
		ret.add(new Location(this.XCoord + 1, this.YCoord + 1));
		ret.add(new Location(this.XCoord + 0, this.YCoord + 1));
		ret.add(new Location(this.XCoord - 1, this.YCoord + 1));
		ret.add(new Location(this.XCoord - 1, this.YCoord + 0));
		ret.add(new Location(this.XCoord - 1, this.YCoord - 1));
		ret.add(new Location(this.XCoord + 0, this.YCoord - 1));
		ret.add(new Location(this.XCoord + 1, this.YCoord - 1));
		return ret;
	}
}

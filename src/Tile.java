/**
 * this class represents a tile in the colored tile puzzle game
 * @author oriel
 *
 */
public class Tile {
	
	private int color = 1; // 1 = green, 2 = red, 3 = black
	private int val;
	
	public Tile(int v) {
		val = v;
	}
	
	public Tile(int v ,int c) {
		val = v;
		color = c;
		
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}
	
	public String toString() {
		String ans = "("+val+",";
		if(color == 2)
			ans += "R";
		else if(color == 3)
			ans += "B";
		else
			ans += "G";
		return ans+")";
	}
	/**
	 * returns true if two tiles are equal.
	 */
	
	public boolean equals(Object obj) {
		if(obj instanceof Tile) {
			Tile tOther = (Tile)obj;
			return val == tOther.val && color == tOther.color;
		}
		return false;
	}

}

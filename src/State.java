import java.util.Arrays;
import java.util.Date;

public class State {

	private int iteration;
	private String id = "";
	private int localPriority = 0; // 1 = left, 2 = up, 3 = right, 4 = down
	private int tag;
	private double weight;
	private String info = "", path = "";
	private Tile[][] mat;
	private int rows, columns;
	private int iOfEmpty, jOfEmpty;

	public State(Tile[][] mat) {
		this.mat = mat;
		rows = mat.length;
		columns = mat[0].length;
		for(int i =0; i<rows; i++) {
			for(int j = 0; j<columns; j++) {
				if(mat[i][j] == null) {
					iOfEmpty = i;
					jOfEmpty = j;
				}
			}
		}
		updateID();
	}
	
	
	public String getId() {
		return id;
	}

	public int getIteration() {
		return iteration;
	}

	public void setIteration(int iteration) {
		this.iteration = iteration;
	}
	

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getLocalPriority() {
		return localPriority;
	}

	public void setLocalPriority(int localPriority) {
		this.localPriority = localPriority;
	}
	

	public int getiOfEmpty() {
		return iOfEmpty;
	}

	public void setiOfEmpty(int iOfEmpty) {
		this.iOfEmpty = iOfEmpty;
	}

	public int getjOfEmpty() {
		return jOfEmpty;
	}

	public void setjOfEmpty(int jOfEmpty) {
		this.jOfEmpty = jOfEmpty;
	}

	public int getTag() {
		return tag;
	}

	public void setTag(int tag) {
		this.tag = tag;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public String toString() {
		String ans = "";
		for(int i =0; i<mat.length; i++) {
			ans += Arrays.deepToString(mat[i]) + "\n";
		}
		return ans;
	}
	
	public boolean isGoal() {
		int count = 0;
		int numOfTiles = rows*columns -1;
		for(int i =0; i<rows; i++) {
			for(int j = 0; j<columns && count < numOfTiles; j++) {
				if(mat[i][j]==null)
					return false;
				else if(mat[i][j].getVal()!= i*columns + j + 1) {
					return false;
				}
				count++;
			}
		}
		return true;
	}
	
	public State deepCopy() {
		Tile[][] _mat = new Tile[rows][columns];
		for(int i =0; i<rows; i++) {
			for(int j =0; j<columns; j++) {
				_mat[i][j] = new Tile(mat[i][j].getColor(), mat[i][j].getColor());
			}
		}
		State _st = new State(_mat);
		return _st;
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof State) {
			State sOther = (State)obj;
			return id.equals(sOther.id);
		}
		return false;
	}
	public void updateID() {
		id = "";
		for(int i =0; i<rows; i++) {
			for(int j =0; j<columns; j++) {
				if(mat[i][j] != null)
					id += mat[i][j].getVal() + mat[i][j].getColor();
			}
		}
	}
	// moveleft/right/up..
}

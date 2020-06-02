/**
 * this class represents a state in the colored tile puzzle game
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class State {

	private int iteration;
	private String id = "";
	private int localPriority = -1; // 0 = left, 1 = up, 2 = right, 3 = down
	private int tag = 0; // 1 = out, 0 = unexplored
	private int cost = 0;
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
		if(path.length()>0)
			return path.substring(1);
		return "no path";
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

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public void setWeight(int cost) {
		this.cost = cost;
	}

	public String toString() {
		String ans = "";
		for(int i =0; i<mat.length; i++) {
			ans += "\n"+Arrays.deepToString(mat[i]);
		}
//				ans += "\ncost: "+cost+ ", h(): " + h() + ", itr: "+iteration+ ", localPriority: "+localPriority+ ", path: "+ path;
		return ans+"\n";
	}
	/**
	 * returns true if and only if this state is a solution to this game
	 * @return
	 */

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

	/**
	 * returns deep copy of the current state
	 * @return
	 */

	public State deepCopy() {
		Tile[][] _mat = new Tile[rows][columns];
		for(int i =0; i<rows; i++) {
			for(int j =0; j<columns; j++) {
				if(mat[i][j]!=null)
					_mat[i][j] = new Tile(mat[i][j].getVal(), mat[i][j].getColor());
			}
		}
		State _st = new State(_mat);
		_st.path = path;
		_st.cost = cost;
		return _st;
	}

	/**
	 * checks if two states are equals, returns true if their id (which needs to be uniqe) are the same
	 */

	public boolean equals(Object obj) {
		if(obj instanceof State) {
			State sOther = (State)obj;
			return id.equals(sOther.id);
		}
		return false;
	}

	/**
	 * updating State id if the state was changed
	 */
	public void updateID() {
		id = "";
		for(int i =0; i<rows; i++) {
			for(int j =0; j<columns; j++) {
				if(mat[i][j] != null) {
					String t = "";
					switch(mat[i][j].getColor()) {
					case 1:
						t += "G";
						break;
					case 2:
						t += "R";
						break;
					case 3:
						t += "B";
						break;
					}
					id += mat[i][j].getVal() + t ;
				} else {
					id += "-null-";
				}
			}
		}
	}

	/**
	 * the heuristic method - checks how many blocks (tiles) are away from their right place,
	 * and multiple the distance with their color (for each tile!) 
	 * eventually sums it all and returning the prediction
	 * @return
	 */

	public int h() {
		int sum = 0;
		for(int i =0; i<rows; i++) {
			for(int j =0; j<columns; j++) {
				if(mat[i][j]!=null && mat[i][j].getVal()!= i*columns + j + 1) {
					int number = mat[i][j].getVal();
					int color = mat[i][j].getColor();
					if(color == 3)
						throw new RuntimeException("ERR: cant solve this game, got black tile on row "+i+" and column "+j);
					int r, c;
					if(number%columns==0) {
						r = number/columns -1;
						c = columns-1;
					} else {
						r = number/columns;
						c = number%columns -1;
					}
					int sumr = Math.abs(i - r);
					int sumc = Math.abs(j - c);
					sum += sumr + sumc;
					if(color==2) {
						sum *= 30;
					}

				}
			}
		}
		return sum;
	}
	/**
	 * returns ArrayList of all the children of the state
	 * @return
	 */

	public ArrayList<State> getChildren(){
		ArrayList<State> arr = new ArrayList<State>();
		for(int i =0; i<4; i++) {
			State son = this.getChild(i);
			if(son!=null)
				arr.add(son);
		}
		return arr;
	}

	public State getChild(int priority) {
		if(localPriority != -1 && ((localPriority+2)%4)==priority) return null;

		switch (priority) {
		case 0:
			if((jOfEmpty+1)!= columns && mat[iOfEmpty][jOfEmpty+1].getColor() != 3) {
				State left = deepCopy();
				left.mat[left.iOfEmpty][left.jOfEmpty] = left.mat[left.iOfEmpty][left.jOfEmpty+1];
				left.jOfEmpty++;
				left.mat[left.iOfEmpty][left.jOfEmpty] = null;
				left.localPriority = 0;
				left.path += "-"+left.mat[left.iOfEmpty][left.jOfEmpty-1].getVal()+"L";
				switch(left.mat[left.iOfEmpty][left.jOfEmpty-1].getColor()) {
				case 1:
					left.cost = cost + 1;
					break;
				case 2: 
					left.cost = cost + 20;
					break;
				case 3:
					throw new RuntimeException("ERR: cant move black tile");
				}
				left.updateID();
				return left;
			}
			break;
		case 1:
			if((iOfEmpty+1)!= rows && mat[iOfEmpty+1][jOfEmpty].getColor() != 3) {
				State up = deepCopy();
				up.mat[up.iOfEmpty][up.jOfEmpty] = up.mat[up.iOfEmpty+1][up.jOfEmpty];
				up.iOfEmpty++;
				up.mat[up.iOfEmpty][up.jOfEmpty] = null;
				up.localPriority = 1;
				up.path += "-"+up.mat[up.iOfEmpty-1][up.jOfEmpty].getVal()+"U";
				switch(up.mat[up.iOfEmpty-1][up.jOfEmpty].getColor()) {
				case 1:
					up.cost = cost + 1;
					break;
				case 2: 
					up.cost = cost + 20;
					break;
				case 3:
					throw new RuntimeException("ERR: cant move black tile");
				}
				up.updateID();
				return up;
			}
			break;
		case 2:
			if(jOfEmpty!=0 && mat[iOfEmpty][jOfEmpty-1].getColor() != 3) {
				State right = deepCopy();
				right.mat[right.iOfEmpty][right.jOfEmpty] = right.mat[right.iOfEmpty][right.jOfEmpty-1];
				right.jOfEmpty--;
				right.mat[right.iOfEmpty][right.jOfEmpty] = null;
				right.localPriority = 2;
				right.path += "-"+right.mat[right.iOfEmpty][right.jOfEmpty+1].getVal()+"R";
				switch(right.mat[right.iOfEmpty][right.jOfEmpty+1].getColor()) {
				case 1:
					right.cost = cost + 1;
					break;
				case 2: 
					right.cost = cost + 20;
					break;
				case 3:
					throw new RuntimeException("ERR: cant move black tile");
				}
				right.updateID();
				return right;
			}
			break;
		case 3:
			if(iOfEmpty != 0 && mat[iOfEmpty-1][jOfEmpty].getColor() != 3) {
				State down = deepCopy();
				down.mat[down.iOfEmpty][down.jOfEmpty] = down.mat[down.iOfEmpty-1][down.jOfEmpty];
				down.iOfEmpty--;
				down.mat[down.iOfEmpty][down.jOfEmpty] = null;
				down.localPriority = 3;
				down.path += "-"+down.mat[down.iOfEmpty+1][down.jOfEmpty].getVal()+"D";
				switch(down.mat[down.iOfEmpty+1][down.jOfEmpty].getColor()) {
				case 1:
					down.cost = cost + 1;
					break;
				case 2: 
					down.cost = cost + 30;
					break;
				case 3:
					throw new RuntimeException("ERR: cant move black tile");
				}
				down.updateID();
				return down;
			}
			break;
		default:
			throw new RuntimeException("ERR: got wrong input to th getChild method, input = "+priority);
		}
		return null;
	}
}




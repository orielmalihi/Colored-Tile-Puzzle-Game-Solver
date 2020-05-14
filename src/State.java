import java.util.Arrays;
import java.util.Date;

public class State {

	private int iteration, localPriority;
	private int tag;
	private double weight;
	private String info = "";
	private Tile[][] mat;

	public State(Tile[][] mat) {
		this.mat = mat;
	}
	
	public int getIteration() {
		return iteration;
	}

	public void setIteration(int iteration) {
		this.iteration = iteration;
	}

	public int getLocalPriority() {
		return localPriority;
	}

	public void setLocalPriority(int localPriority) {
		this.localPriority = localPriority;
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
		int n = mat.length;
		int m = mat[0].length;
		int numOfTiles = n*m -1;
		for(int i =0; i<n; i++) {
			for(int j = 0; j<m && count < numOfTiles; j++) {
				if(mat[i][j]==null)
					return false;
				else if(mat[i][j].getVal()!= i*m + j + 1) {
					return false;
				}
				count++;
			}
		}
		return true;
	}
}

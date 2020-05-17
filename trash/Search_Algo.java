
public class Search_Algo {
	
	private State st;
	private boolean withTime, withOpen, hasResult = false;
	private String path = ""; // will be given from the goal state
	private int num = 0, cost = 0; // cost is the weight of the goal state
	private long timeToGoal =0;
	
	public Search_Algo(State first, boolean time, boolean open) {
		st = first;
		withTime = time;
		withOpen = open;
	}

	public String getPath() {
		return path;
	}

	public int getNum() {
		return num;
	}

	public int getCost() {
		return cost;
	}
	
	public boolean isSolved() {
		return hasResult; 
	}
	
	public long getTime() {
		return timeToGoal;
	}
	
	public void clear() {
		path = "";
		num = 0;
		cost = 0;
		timeToGoal = 0;
	}
}

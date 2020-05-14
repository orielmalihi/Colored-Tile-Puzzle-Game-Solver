
public class Search_Algo {
	
	private State st;
//	private String algo;
	private boolean withTime, withOpen, hasResult = false;
	private String path = "";
	private int num = 0, cost = 0;
	private long timeToGoal = 0;
	
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
	

}

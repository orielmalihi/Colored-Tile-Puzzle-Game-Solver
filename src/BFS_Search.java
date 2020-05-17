
public class BFS_Search implements search_algorithms {
	private State st;
	private boolean isWithTime, isWithOpen, hasResult = false;
	private String path = ""; // will be given from the goal state
	private int num = 0, cost = 0; // cost is the weight of the goal state
	private long timeToGoal =0;

	public BFS_Search(State first, boolean time, boolean open) {
		st = first;
		isWithTime = time;
		isWithOpen = open;
	}

	@Override
	public void solve_game() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isSolved() {
		// TODO Auto-generated method stub
		return hasResult;
	}

	@Override
	public String getPath() {
		// TODO Auto-generated method stub
		return path;
	}

	@Override
	public int getNum() {
		// TODO Auto-generated method stub
		return num;
	}

	@Override
	public int getCost() {
		// TODO Auto-generated method stub
		return cost;
	}

	@Override
	public long getTime() {
		// TODO Auto-generated method stub
		return timeToGoal;
	}

}

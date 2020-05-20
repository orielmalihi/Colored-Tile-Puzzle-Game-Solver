import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;

public class BFS_Search implements search_algorithms {
	private State st;
	private String path = ""; // from the goal state
	private boolean isWithTime, isWithOpen, hasResult = false;
	private int num = 1, cost = 0; // cost is the weight of the goal state
	private long timeToGoal =0;

	public BFS_Search(State first, boolean time, boolean open) {
		st = first;
		isWithTime = time;
		isWithOpen = open;
	}

	@Override
	public void solve_game() {
		// TODO Auto-generated method stub
		if(st == null) return;
		long startTime = new Date().getTime();
		Queue<State> queue = new LinkedList<State>();
		Hashtable<String,State> openList = new Hashtable<String,State>();
		Hashtable<String,State> closedList = new Hashtable<String,State>();
		queue.add(st);
		openList.put(st.getId(), st);
		while(!queue.isEmpty() && !hasResult) {
			if(isWithOpen)
				System.out.println("***************** Open List: **********************\n"+openList);
			State t = queue.poll();
			openList.remove(t.getId());
			closedList.put(t.getId(), t);
			for(int i = 0; i<4; i++) {
				State son = t.getChild(i);
				if(son == null) continue;
				num++;
				if(closedList.get(son.getId())==null && openList.get(son.getId())==null) {
					if(son.isGoal()) {
						cost = son.getCost();
						path = son.getPath();
						hasResult = true;
						long finishTime = new Date().getTime();
						timeToGoal = finishTime - startTime;
						return;
					} else {
						queue.add(son);
						openList.put(son.getId(), son);
					}
				}
			}
		}
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

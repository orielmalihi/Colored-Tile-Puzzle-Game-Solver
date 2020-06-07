import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class A_Star_Search implements search_algorithms {

	private State st;
	private String path = ""; // from the goal state
	private boolean isWithTime, isWithOpen, hasResult = false;
	private int num = 1, cost = 0; // cost is the weight of the goal state
	private long timeToGoal =0;
	
	public A_Star_Search(State first, boolean time, boolean open) {
		st = first;
		isWithTime = time;
		isWithOpen = open;
	}


	@Override
	public void solve_game() {
		// TODO Auto-generated method stub
		if(st == null) return;
		long startTime = new Date().getTime();
		PriorityQueue<State> priority_queue =  new PriorityQueue<State>(new State_Comparator_Heuristic());
		Hashtable<String,State> openList = new Hashtable<String,State>();
		Hashtable<String,State> closedList = new Hashtable<String,State>();
		priority_queue.add(st);
		openList.put(st.getId(), st);
		int itr = 0;
		while(!priority_queue.isEmpty() && !hasResult) {
			itr++;
			if(isWithOpen)
				System.out.println("***************** Open List: **********************\n"+openList);
			State t = priority_queue.poll();
			openList.remove(t.getId());
			if(t.isGoal()) {
				cost = t.getCost();
				path = t.getPath();
				hasResult = true;
				long finishTime = new Date().getTime();
				timeToGoal = finishTime - startTime;
				return;
			}

			closedList.put(t.getId(), t);
			for(int i =0; i<4; i++) {
				State son = t.getChild(i);
				if(son == null) continue;
				num++;
				son.setIteration(itr);
				if(closedList.get(son.getId())==null && openList.get(son.getId())==null) {
					openList.put(son.getId(), son);
					priority_queue.add(son);
				} else if(openList.get(son.getId())!=null) {
					State check = openList.get(son.getId());
					if(son.getCost() + son.h() < check.getCost() + check.h()) {
						openList.remove(check.getId());
						priority_queue.remove(check);
						openList.put(son.getId(), son);
						priority_queue.add(son);
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

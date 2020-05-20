import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.PriorityQueue;
import java.util.Stack;

public class DFBnB_Search implements search_algorithms {

	private State st;
	private String path = ""; // from the goal state
	private boolean isWithTime, isWithOpen, hasResult = false;
	private int num = 1, cost = 0; // cost is the weight of the goal state
	private long timeToGoal =0;

	public DFBnB_Search(State first, boolean time, boolean open) {
		st = first;
		isWithTime = time;
		isWithOpen = open;
	}


	@Override
	public void solve_game() {
		// TODO Auto-generated method stub
		if(st == null) return;
		long startTime = new Date().getTime();
		Hashtable<String, State> openList = new Hashtable<String, State>();
		Stack<State> stack = new Stack<State>();
		int currentBest = 700;
		openList.put(st.getId(), st);
		int itr = 0;
		stack.add(st);
		while(!stack.isEmpty()) {
			itr++;
			if(isWithOpen)
				System.out.println("***************** Open List: **********************\n"+openList);
			State t = stack.pop();
			if(t.getTag()==1) {
				openList.remove(t.getId());
			} else {
				t.setTag(1);
				stack.add(t);
				ArrayList<State> children = t.getChildren();
				updateIteration(children, itr);
				children.sort(new State_Comparator_Heuristic()); 
				for(int i =0; i<children.size(); i++) {
					num++;
					State son = children.get(i);
					int f_son = son.getCost() + son.h();
					State copy = openList.get(son.getId());
					if(f_son >= currentBest) {
						for(int j =i; j<children.size(); j++)
							children.remove(i);
					}
					else if(copy!=null && copy.getTag()==1) {
						children.remove(i);
						i--;
					}
					else if(copy!=null && copy.getTag()==0) {
						if(f_son >= copy.getCost() + copy.h()) {
							children.remove(i);
							i--;
						} else {
							openList.remove(copy.getId());
							stack.remove(copy);
						}
					}
					else if(son.isGoal()) {
						currentBest = f_son;
						cost = son.getCost();
						path = son.getPath();
						hasResult = true;
						long finishTime = new Date().getTime();
						timeToGoal = finishTime - startTime;
						for(int j =i; j<children.size(); j++)
							children.remove(i);

					}
					
					
				}
				for(int k = children.size()-1; k>=0; k--) {
					State son2 = children.get(k);
					openList.put(son2.getId(), son2);
					stack.add(son2);
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

	public void updateIteration(ArrayList<State> arr, int itr) {
		for(int i =0; i<arr.size(); i++) {
			arr.get(i).setIteration(itr);
		}
	}



}

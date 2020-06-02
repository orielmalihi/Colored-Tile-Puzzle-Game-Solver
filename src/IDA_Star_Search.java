import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.PriorityQueue;
import java.util.Stack;

public class IDA_Star_Search implements search_algorithms {

	private State st;
	private String path = ""; // from the goal state
	private boolean isWithTime, isWithOpen, hasResult = false;
	private int num = 1, cost = 0; // cost is the weight of the goal state
	private long timeToGoal =0;

	public IDA_Star_Search(State first, boolean time, boolean open) {
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
		int threshold = st.h();
		while(threshold < Integer.MAX_VALUE) {
			int minF = Integer.MAX_VALUE;
			stack.add(st);
			openList.put(st.getId(), st);
			while(!stack.isEmpty()) {
				if(isWithOpen)
					System.out.println("***************** Open List: **********************\n"+openList);
				State t = stack.pop();
				if(t.getTag()==1) {
					openList.remove(t.getId());
				} else {
					t.setTag(1);
					openList.put(t.getId(), t);
					for(int i =0; i<4; i++) {
						State son = t.getChild(i);
						if(son == null) continue;
						num++;
						int f_son = son.getCost() + son.h();
//						System.out.println("my f value: "+f_son);
						if(f_son > threshold) {
							minF = Math.min(minF, f_son);
//							System.out.println("improving.. "+son);
							continue;
						}
						State copy = openList.get(son.getId());
						if(copy!=null && copy.getTag()==1) {
							continue;
						}
						if(copy!=null && copy.getTag()==0) {
							if(f_son < copy.getCost() + copy.h()) {
								openList.remove(copy.getId());
								stack.remove(copy);
							} else {
								continue;
							}
						}
						if(son.isGoal()) {
							cost = son.getCost();
							path = son.getPath();
							hasResult = true;
							long finishTime = new Date().getTime();
							timeToGoal = finishTime - startTime;
							return;
						}
						openList.put(son.getId(), son);
						stack.add(son);
					}
				}
			}
//			System.out.println("current t: "+threshold+ ", current minF: "+minF);
			threshold = minF;
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

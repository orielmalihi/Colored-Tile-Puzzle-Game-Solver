import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;

public class DFID_Search implements search_algorithms {

	private State st;
	private String path = ""; // from the goal state
	private boolean isWithTime, isWithOpen, hasResult = false;
	private int num = 1, cost = 0; // cost is the weight of the goal state
	private long timeToGoal =0;
	
	public DFID_Search(State first, boolean time, boolean open) {
		st = first;
		isWithTime = time;
		isWithOpen = open;
	}

	@Override
	public void solve_game() {
		// TODO Auto-generated method stub
		if(st == null) return;
		long startTime = new Date().getTime();
		for(int i =1; i<Integer.MAX_VALUE; i++) {
			Hashtable<String,State> hash = new Hashtable<String, State>();
			boolean _hasResult = recursive_DFID(st, i, hash);
			if(_hasResult) {
				hasResult = true;
				long finishTime = new Date().getTime();
				timeToGoal = finishTime - startTime;
				return;
			}
		}	
	}
	
	private boolean recursive_DFID(State st, int limit, Hashtable<String,State> hash) {
		
		if(st.isGoal()) {
			path = st.getPath();
			cost = st.getCost();
			return true;
		}
		if(limit==0) return false;
		
		hash.put(st.getId(), st);
		for(int i=0; i<4; i++) {
			State son = st.getChild(i);
			if(son == null) continue;
			num++;
			if(hash.get(son.getId())==null) {
				boolean hasResult_t = recursive_DFID(son, limit-1, hash);
				if(hasResult_t) {
					return true;
				}
			}
		}
		hash.remove(st.getId());
		return false;
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

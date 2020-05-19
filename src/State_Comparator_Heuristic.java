/**
 * this comperator allows us to compare two States by their cost and their heuristic method,
 * if their value is the same they will be compared by their time of creation
 */
import java.util.Comparator;


public class State_Comparator_Heuristic  implements Comparator<State>{


	public State_Comparator_Heuristic() {;}
	public int compare(State s1, State s2) {
		int f1 = s1.getCost() + s1.h();
		int f2 = s2.getCost() + s2.h();
		if(f1 != f2)
			return  f1 - f2;
		else if(s1.getIteration()!=s2.getIteration())
			return s1.getIteration() - s2.getIteration();
		else {
			return s1.getLocalPriority() - s2.getLocalPriority();
		}
		
	}

	

}




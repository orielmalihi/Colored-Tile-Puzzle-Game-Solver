import java.util.ArrayList;
import java.util.PriorityQueue;

public class testing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Tile[][] mat = new Tile[2][2];
		mat[0][0] = new Tile(1);
		mat[0][1] = new Tile(2);
		mat[1][0] = new Tile(3);
		State st = new State(mat);
//		st.setCost(20);
//		st.setIteration(8);
//		st.setLocalPriority(3);
//		System.out.println("st: cost :"+st.getCost());
//		
//		Tile[][] mat2 = new Tile[2][2];
//		mat2[0][0] = new Tile(4);
//		mat2[0][1] = new Tile(5);
//		mat2[1][0] = new Tile(6);
//		State st2 = new State(mat2);
//		st2.setCost(20);
//		st2.setIteration(8);
//		st2.setLocalPriority(2);
//		System.out.println("st2: cost :"+st2.getCost());
//		PriorityQueue<State> pq = new PriorityQueue<State>(new State_Comperator_Astar());
//		pq.add(st);
//		pq.add(st2);
//		
//		System.out.println("pq: "+pq);
//		System.out.println("pq peek: "+pq.peek());
		
		
		
		
		
//		
//	
//		System.out.println(st + "\npath: "+ st.getPath()+ ", id: "+st.getId() + ", cost: "+st.getCost() + ", f(): "+st.h());
//		System.out.println("****** children: ******");
//		ArrayList<State> ttt = st.getChildren();
//		for(int i =0; i<ttt.size(); i++) {
//			System.out.println(ttt.get(i) + "\npath:"+ ttt.get(i).getPath() + ", id: "+ttt.get(i).getId()+ ", cost: "+ttt.get(i).getCost()+ ", f(): "+ttt.get(i).h());
//			System.out.println();
//		}
//
//
//
//		ArrayList<State> ttt2 = ttt.get(0).getChildren();
//		System.out.println("******* grand-children: *******");
//		for(int i =0; i<ttt2.size(); i++) {
//			System.out.println(ttt2.get(i) +"\npath: "+ ttt2.get(i).getPath()+ ", id: "+ttt2.get(i).getId()+ ", cost: "+ttt2.get(i).getCost()+ ", f(): "+ttt2.get(i).h());
//		}
//
//		System.out.println("^^^^^^^^^^^^^^^");
//		System.out.println(ttt);
//		//System.out.println(st);

	}

}

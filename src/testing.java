import java.util.ArrayList;

public class testing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Tile[][] mat = new Tile[2][2];
		mat[0][0] = new Tile(1,2);
		mat[0][1] = new Tile(2);
		mat[1][0] = new Tile(3);
		State st = new State(mat);
		System.out.println(st + "\npath: "+ st.getPath()+ ", id: "+st.getId() + ", cost: "+st.getCost());
		System.out.println("****** children: ******");
		ArrayList<State> ttt = st.getChildren();
		for(int i =0; i<ttt.size(); i++) {
			System.out.println(ttt.get(i) + "\npath:"+ ttt.get(i).getPath() + ", id: "+ttt.get(i).getId()+ ", cost: "+ttt.get(i).getCost());
			System.out.println();
		}



		ArrayList<State> ttt2 = ttt.get(0).getChildren();
		System.out.println("******* grand-children: *******");
		for(int i =0; i<ttt2.size(); i++) {
			System.out.println(ttt2.get(i) +"\npath: "+ ttt2.get(i).getPath()+ ", id: "+ttt2.get(i).getId()+ ", cost: "+ttt2.get(i).getCost());
		}

		System.out.println("^^^^^^^^^^^^^^^");
		System.out.println(ttt);
		//System.out.println(st);

	}

}

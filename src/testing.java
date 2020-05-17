import java.util.ArrayList;

public class testing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Tile[][] mat = new Tile[2][2];
		mat[0][0] = new Tile(1);
		mat[0][1] = new Tile(2);
		mat[1][0] = new Tile(3);
		State st = new State(mat);
		System.out.println(st + "path: "+ st.getPath()+ ", id: "+st.getId());
		System.out.println("****** children: ******");
		ArrayList<State> ttt = st.getChildren();
		for(int i =0; i<ttt.size(); i++) {
			System.out.println(ttt.get(i) + "path:"+ ttt.get(i).getPath() + ", id: "+ttt.get(i).getId());
			System.out.println();
		}
		
		ArrayList<State> ttt2 = ttt.get(0).getChildren();
		System.out.println("******* grand-children: *******");
		for(int i =0; i<ttt2.size(); i++) {
			System.out.println(ttt2.get(i) + ttt2.get(i).getPath()+ ","+ttt2.get(i).getId());
		}
		
		//System.out.println(st);

	}

}

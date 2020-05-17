import java.io.IOException;
import java.util.Date;

public class Ex1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ColoredTilePuzzle_AI game = new ColoredTilePuzzle_AI();
		try {
			game.LoadGame("input.txt");
			System.out.println(game.getFirstState());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		game.printResult();
		game.saveResult("output-test!.txt");
		
		Tile[][] mat = new Tile[2][2];
		mat[0][0] = new Tile(1);
		mat[0][1] = new Tile(2);
		mat[1][0] = new Tile(3);
		State st = new State(mat);
		System.out.println();
		System.out.println(st);
		
		
		
		
//		long t1 = new Date().getTime();
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		long t2 = new Date().getTime();
//		System.out.println((t2-t1)/1000.0);

	}

}

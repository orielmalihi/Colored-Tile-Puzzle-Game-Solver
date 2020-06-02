/**
 * this class is the main class which needs to actually run and solve the game.
 */
import java.io.IOException;
//try to generate now.

public class Ex1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ColoredTilePuzzle_AI game = new ColoredTilePuzzle_AI();
		String path = "input4.txt";
		try {
			game.LoadGame(path);
			game.solve();
			System.out.println("\nfile name: "+path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Algorithm: "+game.getAlgo()+ "\nfirst state: "+game.getFirstState()+"\n***** result: *****");
		game.printResult();
		game.saveResult("output.txt");
		System.out.println("the result has been saved successfully in the program folder!\ngood-bye.");

	}

}

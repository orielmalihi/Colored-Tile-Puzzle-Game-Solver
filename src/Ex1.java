import java.io.IOException;
import java.util.Arrays;
import java.util.Date;



public class Ex1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ColoredTilePuzzle_AI game = new ColoredTilePuzzle_AI();
		String path = "input.txt";
		try {
			game.LoadGame(path);
			System.out.println("\nfile name: "+path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Algorithm: "+game.getAlgo()+ "\nfirst state: "+game.getFirstState()+"\n***** result: *****");
		game.printResult();
		game.saveResult("output.txt");
		System.out.println("\nthe result has been saved successfully in the program folder!\ngood-bye.");

	}

}

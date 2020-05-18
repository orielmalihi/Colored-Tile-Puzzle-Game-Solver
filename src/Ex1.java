import java.io.IOException;
import java.util.Date;

public class Ex1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ColoredTilePuzzle_AI game = new ColoredTilePuzzle_AI();
		try {
			game.LoadGame("input-IDA-Star.txt");
			System.out.println(game.getFirstState());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		game.printResult();
//		System.out.println("h(): "+game.getFirstState().h());
		game.saveResult("output-test!.txt");
		

	}

}

/**
 * this interface represents the methods each search algorithm must have
 * @author oriel
 *
 */
public interface search_algorithms {
	/**
	 * solving the game and updating the members of the search object
	 */
	public void solve_game();
	/**
	 * return true if and only if the game has at least one solution
	 * @return
	 */
	public boolean isSolved();
	/**
	 * returns the path to the solution
	 * (not necessary the optimal solution! it depends which search algorithm is used)
	 * @return
	 */
	public String getPath();
	/**
	 * returns the number of states that were created
	 * @return
	 */
	public int getNum();
	/**
	 * returns the cost to the solution
	 * @return
	 */
	public int getCost();
	/**
	 * returns the time it took the algorithm to get to the solution
	 * @return
	 */
	public long getTime();

}

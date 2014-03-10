package framework;

import java.util.List;

/**
 * This interface encapsulates a saved game and the connection to the saved place. It
 * is through this new rounds will be saved and old will be restore, as well as keeping track of 
 * all the previous states.
 * @author Jesper
 *
 */

public interface SavedGame {

	/**
	 * Get a calculator associated with this game. This will be used by the game
	 * to calculate new scores
	 * @return a ScoreCalculator to be used for score calculations
	 */
	public ScoreCalculator getCalculator();
	
	/**
	 * Get the state previous to the current.
	 * If none is available, ie. we are at the first state, an empty array should be passed.
	 * @return the previous state represented as an integer array
	 */
	public int[] undo();
	
	/**
	 * Get the next state after the current.
	 * If none is available, ie. we are at the last state, an empty array should be passed.
	 * @return
	 */
	public int[] redo();
	
	/**
	 * Return a list of players. Notice that the SavedWhistCalculatorImpl will NOT use the same objects, but
	 * will use the correct name and balance
	 * @return a list of players in the game
	 */
	public List<Player> getPlayers();
	
	/**
	 * Adds a new score to the saved game, which must be stored somewhere.
	 * This method is called by the game at the end of each round.
	 * @param newScore an integer array containing the new scores in the same order as the list of players
	 */
	public void addNewScores(int[] newScore);
}

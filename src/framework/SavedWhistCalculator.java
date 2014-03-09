package framework;

public interface SavedWhistCalculator extends WhistCalculator{

	/**
	 * Set the game to the previous state
	 */
	public void undo();
	
	/**
	 * If undo has been used, this will return the state to the following state.
	 * If the most recent state is present, nothing will happen.
	 * If endOfRound() is used, all following states will be deleted, and redo will do nothing.
	 */
	public void redo();

	/**
	 * Loads a saved game and saves new changes to the game through this
	 * @param game
	 */
	public void loadGame(SavedGame game);
	
}

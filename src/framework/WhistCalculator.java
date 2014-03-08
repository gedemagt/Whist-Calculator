package framework;

import java.util.List;

/**
 * This interface is a facade into the game. It shall be possible to inject different score calculators and 
 * history strategies.
 * 
 * This interface have the following responsibilities:
 *  - Make sure the score is updated and the history strategy is informed at the end of the turn
 *  - Keep track of the players currently playing, and currently waiting
 *  - Notify listernes when a round has ended
 * @author Jesper
 *
 */

public interface WhistCalculator {

	/**
	 * Calling this should end the round and calculate the score.
	 */
	public void endRound(RoundResult result);
	
	/**
	 * The players in the game. The order will be consistent throughout the game, and will 
	 * always be the same as when the game started.
	 * @return A list of players, participating in the current game
	 */
	public List<Player> getPlayers();
	
	/**
	 * The players participating in the current round. If there are only players in the game, it will return the same as getPlayers().
	 * @return A list of players, participating in the current round.
	 */
	public List<Player> getRoundPlayers();
	
	/**
	 * Register listeners for when a score has been calculated etc...
	 * @param listener a listener to be notified when something happens
	 */
	public void registerGameUpdateListener(GameUpdateListener listener);
}

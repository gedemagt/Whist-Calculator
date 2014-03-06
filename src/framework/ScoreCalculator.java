package framework;

public interface ScoreCalculator {

	/**
	 * Calculate the new scores and return them. The scores should be in the same 
	 * order as the players are in the list returned by calc.getCurrentPlayers().
	 * @param result the result of the round
	 * @param calc the current calculator used
	 * @return an integer array containing the new score, order as the players in the list returned by the calc.getCurrentPlayers() method
	 */
	public int[] calculateScore(RoundResult result, WhistCalculator calc);
	
}

package framework;

import java.util.List;
import java.util.Map;

import framework.enums.Addition;
import framework.enums.CardSuite;

public interface RoundResult {

	public static final int SOLO = 1;
	public static final int SOLONOLO = 0;
	public static final int ON_THE_TABLE = -1;
	
	/**
	 * The actual amount of tricks got by the leading team
	 * @return the gotten amount of tricks
	 */
	public int getTricks();
	
	/**
	 * The trumph suite played
	 * @return the trumph suite played
	 */
	public CardSuite getTrumph();
	
	/**
	 * The estimated amount of cards the winning team would get. Note this can be SOLO, SOLONOLO and ON_THE_TABLE too.
	 * @return the amount of cards the winning team a least should have gotten.
	 */
	public int getMelding();
	
	/**
	 * The addition, if such was present. This could be VIP or likewise
	 * @return the addition of a call
	 */
	public Addition getAddition();
	
	/**
	 * A list of the winning people. This can be one or two.
	 * @return A list of winning people
	 */
	public List<Player> getWinners();
	
	/**
	 * A list of the callers. This can be one or two.
	 * @return a list of the callers
	 */
	public List<Player> getCallers();
	
	/**
	 * A map of user defined extra values to be used in the score calculation
	 * @return a map with key-value extra information, if such is needed.
	 */
	public Map<String, String> getExtra();
}

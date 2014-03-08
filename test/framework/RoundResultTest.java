package framework;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import framework.enums.Addition;
import framework.enums.CardSuite;
import implementations.PlayerImpl;
import implementations.RoundResultImpl;

import org.junit.Before;
import org.junit.Test;

public class RoundResultTest {

	private RoundResult result;
	private Addition addition = Addition.GOOD;
	private int tricks = 10;
	private int melding = 9;
	private CardSuite trumph = CardSuite.CLUBS;
	private List<Player> winners;
	private List<Player> callers;
	
	private String tag = "vipcount";
	private String value = "2";
	
	@Before
	public void setup() {
		winners = new ArrayList<Player>();
		winners.add(new PlayerImpl("player 1", 2));
		winners.add(new PlayerImpl("player 2", 2));
		
		callers = new ArrayList<Player>();
		callers.add(new PlayerImpl("player 3", 2));
		callers.add(new PlayerImpl("player 4", 2));
	}
	
	@Test
	public void shouldBuildResultCorrectly() {
		result = new RoundResultImpl.RoundResultBuilder()
			.addition(addition)
			.caller(callers.get(0))
			.caller(callers.get(1))
			.winner(winners.get(0))
			.winner(winners.get(1))
			.tricks(tricks)
			.melding(melding)
			.trumph(trumph)
			.extra(tag, value)
			.build();
		
		assertEquals(addition, result.getAddition());
		assertEquals(melding, result.getMelding(), 0);
		assertEquals(tricks, result.getTricks(), 0);
		assertEquals(trumph, result.getTrumph());
		assertEquals(winners, result.getWinners());
		assertEquals(callers, result.getCallers());
		assertEquals(value, result.getExtra().get(tag));
	}
	
}

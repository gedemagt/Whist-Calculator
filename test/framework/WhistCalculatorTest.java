package framework;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import implementations.PlayerImpl;
import implementations.WhistCalculatorImpl;

import stubs.DoubleScoreCalculator;
import stubs.NullResult;

public class WhistCalculatorTest {

	private WhistCalculator calc;
	
	@Before
	public void setup() {
		calc = new WhistCalculatorImpl(new DoubleScoreCalculator());
	}
	
	@Test
	public void shouldGetListOfPlayers() {
		
	}
	
	@Test
	public void shouldGetListOfCurrentPlayers() {
		
	}
	
	@Test
	public void shouldBeNotifiedAtTheEndOfTheRound() {
		
	}
	
	@Test
	public void shouldUpdateScoresAtEndOfRound() {
		int startBalance = 2;
		
		List<Player> players = new ArrayList<Player>();
		players.add(new PlayerImpl("player1", startBalance));
		players.add(new PlayerImpl("player2", startBalance));
		players.add(new PlayerImpl("player3", startBalance));
		players.add(new PlayerImpl("player4", startBalance));
		
		calc.endRound(new NullResult());
		for(int i=0; i<4; i++) {
			int currentBalance = calc.getPlayers().get(i).getBalance();
			assertEquals(currentBalance, startBalance*2, 0);
		}
	}
}


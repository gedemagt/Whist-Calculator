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
	int startBalance = 2;
	
	@Before
	public void setup() {
		
		List<PlayerImpl> players = new ArrayList<PlayerImpl>();
		players.add(new PlayerImpl("player1", startBalance));
		players.add(new PlayerImpl("player2", startBalance));
		players.add(new PlayerImpl("player3", startBalance));
		players.add(new PlayerImpl("player4", startBalance));
		players.add(new PlayerImpl("player5", startBalance));
		players.add(new PlayerImpl("player6", startBalance));
		calc = new WhistCalculatorImpl(new DoubleScoreCalculator(), players);
	}
	
	@Test
	public void shouldGetListOfPlayers() {
		
	}
	
	@Test
	public void shouldGetListOfCurrentPlayers() {
		
	}
	
	boolean b = false;
	@Test
	public void shouldBeNotifiedAtTheEndOfTheRound() {
		
		calc.registerGameUpdateListener(new GameUpdateListener() {
			
			@Override
			public void onEndOfRound() {
				b = true;
			}
		});
		calc.endRound(new NullResult());
		assertTrue(b);
	}
	
	@Test
	public void shouldUpdateScoresAtEndOfRound() {
		
		calc.endRound(new NullResult());
		for(int i=0; i<4; i++) {
			int currentBalance = calc.getPlayers().get(i).getBalance();
			assertEquals(currentBalance, startBalance*2, 0);
		}
	}
}


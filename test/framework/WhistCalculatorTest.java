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
	private List<PlayerImpl> players;
	private RoundResult nullResult = new NullResult();
	
	@Before
	public void setup() {
		players = new ArrayList<PlayerImpl>();
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
		List<Player> p = calc.getPlayers();
		for(int i=0; i<p.size(); i++) {
			assertEquals(p.get(i), players.get(i));
		}
	}
	
	@Test
	public void shouldGetListOfCurrentPlayers() {
		List<Player> p = calc.getRoundPlayers();
		for(int i=0; i<4; i++) {
			assertEquals(p.get(i), players.get(i));
		}
	}
	
	@Test
	public void shouldShiftListOfCurrentPlayersAfterRound() {
		calc.endRound(nullResult );
		List<Player> p = calc.getRoundPlayers();
		for(int i=0; i<4; i++) {
			assertEquals(p.get(i).getName(), players.get(i+1).getName());
		}
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
		
		calc.endRound(nullResult);
		for(int i=0; i<4; i++) {
			int currentBalance = calc.getPlayers().get(i).getBalance();
			assertEquals(currentBalance, startBalance*2, 0);
		}
	}
}


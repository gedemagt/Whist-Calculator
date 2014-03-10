package framework;

import static org.junit.Assert.*;
import implementations.SavedWhistCalculatorImpl;

import org.junit.Before;
import org.junit.Test;

import stubs.SavedGameStub;

public class SavedWhistCalculatorTest {

	private SavedGame game;
	private SavedWhistCalculator calc;
	
	@Before
	public void setup() {
		game = new SavedGameStub();
		calc = new SavedWhistCalculatorImpl();
		calc.loadGame(game);
	}
	
	@Test
	public void shouldLoadPlayersCorrectly() {
		assertEquals(game.getPlayers(), calc.getPlayers());
	}
	
	@Test
	public void shouldRedoCorrectly() {
		
	}
	
	@Test
	public void shouldUndoCorrectly() {
		
	}
	
}

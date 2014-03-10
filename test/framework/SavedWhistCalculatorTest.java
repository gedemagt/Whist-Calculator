package framework;

import static org.junit.Assert.*;

import implementations.SavedWhistCalculatorImpl;

import org.junit.Before;
import org.junit.Test;

import stubs.NullResult;
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
	public void shouldUseCalculator() {
		int[] target = new int[6];
		int[] end = new int[6];
		for(int i=0; i<6; i++) {
			int j = calc.getPlayers().get(i).getBalance();
			if(i<4) j *= 2;
			target[i] = j;
		}
		calc.endRound(new NullResult());
		for(int i=0; i<6; i++) {
			end[i] = calc.getPlayers().get(i).getBalance();
		}
		assertArrayEquals(target, end);
	}
	
	@Test
	public void shouldRedoCorrectly() {
		int[] start = new int[6];
		int[] end = new int[6];
		calc.endRound(new NullResult());
		for(int i=0; i<6; i++) {
			start[i] = calc.getPlayers().get(i).getBalance();
		}
		calc.undo();
		calc.redo();
		for(int i=0; i<6; i++) {
			end[i] = calc.getPlayers().get(i).getBalance();
		}
		assertArrayEquals(start, end);
	}
	
	@Test
	public void shouldUndoCorrectly() {
		int[] start = new int[6];
		int[] end = new int[6];
		for(int i=0; i<6; i++) {
			start[i] = calc.getPlayers().get(i).getBalance();
		}
		calc.endRound(new NullResult());
		calc.undo();
		for(int i=0; i<6; i++) {
			end[i] = calc.getPlayers().get(i).getBalance();
		}
		assertArrayEquals(start, end);
	}
	
}

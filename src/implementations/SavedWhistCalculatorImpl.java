package implementations;

import java.util.ArrayList;
import java.util.List;

import framework.GameUpdateListener;
import framework.Player;
import framework.RoundResult;
import framework.SavedGame;
import framework.SavedWhistCalculator;

public class SavedWhistCalculatorImpl implements SavedWhistCalculator {

	private WhistCalculatorImpl c;
	private SavedGame game;
	
	@Override
	public void endRound(RoundResult result) {
		c.endRound(result);
		int[] newScore = new int[c.getPlayers().size()];
		for(int i=0; i<newScore.length; i++) {
			newScore[i] = c.getPlayers().get(i).getBalance();
		}
		game.addNewScores(newScore);
	}

	@Override
	public List<Player> getPlayers() {
		return c.getPlayers();
	}

	@Override
	public List<Player> getRoundPlayers() {
		return c.getRoundPlayers();
	}

	@Override
	public void registerGameUpdateListener(GameUpdateListener listener) {
		c.registerGameUpdateListener(listener);
	}

	@Override
	public void undo() {
		c.setAllScores(game.undo());
	}

	@Override
	public void redo() {
		c.setAllScores(game.redo());
	}

	@Override
	public void loadGame(SavedGame game) {
		this.game = game;
		List<PlayerImpl> p = new ArrayList<PlayerImpl>();
		int[] startScore = new int[game.getPlayers().size()];
		for(Player player : game.getPlayers()) {
			p.add(new PlayerImpl(player.getName(), player.getBalance()));
			startScore[game.getPlayers().indexOf(player)] = player.getBalance();
		}
		c = new WhistCalculatorImpl(game.getCalculator(), p);
		game.addNewScores(startScore);
	}


}

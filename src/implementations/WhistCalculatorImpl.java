package implementations;

import java.util.ArrayList;
import java.util.List;

import framework.GameUpdateListener;
import framework.Player;
import framework.RoundResult;
import framework.ScoreCalculator;
import framework.WhistCalculator;

public class WhistCalculatorImpl implements WhistCalculator {

	private List<GameUpdateListener> listeners;
	private ScoreCalculator score;
	private List<PlayerImpl> allPlayers;
	private List<PlayerImpl> roundPlayers;
	
	public WhistCalculatorImpl(ScoreCalculator score, List<PlayerImpl> players) {
		listeners = new ArrayList<GameUpdateListener>();
		allPlayers = new ArrayList<PlayerImpl>();
		allPlayers.addAll(players);
		roundPlayers = allPlayers.subList(0, 4);
		this.score = score;
	}
	
	@Override
	public void endRound(RoundResult result) {
		int[] newScore = score.calculateScore(result, this);
		setScores(newScore);
		notifyListeners();
	}

	@Override
	public List<Player> getPlayers() {
		List<Player> players = new ArrayList<Player>();
		players.addAll(this.allPlayers);
		return players;
	}

	@Override
	public List<Player> getRoundPlayers() {
		List<Player> players = new ArrayList<Player>();
		players.addAll(this.roundPlayers);
		return players;
	}

	@Override
	public void registerGameUpdateListener(GameUpdateListener listener) {
		listeners.add(listener);
	}
	
	private void notifyListeners() {
		for(GameUpdateListener listener : listeners) {
			listener.onEndOfRound();
		}
	}
	
	private void setScores(int[] newScores) {
		for(int i=0; i<newScores.length; i++) {
			roundPlayers.get(i).setBalance(newScores[i]);
		}
	}

}

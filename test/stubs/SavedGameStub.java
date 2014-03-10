package stubs;

import implementations.PlayerImpl;

import java.util.ArrayList;
import java.util.List;

import framework.Player;
import framework.SavedGame;
import framework.ScoreCalculator;

public class SavedGameStub implements SavedGame {

	private List<int[]> states = new ArrayList<int[]>();
	
	private int currentState;
	
	@Override
	public ScoreCalculator getCalculator() {
		return new DoubleScoreCalculator();
	}

	@Override
	public int[] undo() {
		currentState--;
		return states.get(currentState);
	}

	@Override
	public int[] redo() {
		currentState++;
		return states.get(currentState);
	}

	@Override
	public List<Player> getPlayers() {
		int startBalance = 2;
		List<Player> players = new ArrayList<Player>();
		players.add(new PlayerImpl("player1", startBalance));
		players.add(new PlayerImpl("player2", startBalance));
		players.add(new PlayerImpl("player3", startBalance));
		players.add(new PlayerImpl("player4", startBalance));
		players.add(new PlayerImpl("player5", startBalance));
		players.add(new PlayerImpl("player6", startBalance));
		return players;
	}

	@Override
	public void addNewScores(int[] newScore) {
		for(int i=currentState+1; i<states.size(); i++) {
			states.remove(i);
		}
		states.add(newScore);
		currentState = states.size()-1;
	}

}

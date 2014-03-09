package framework;

import java.util.List;

public interface SavedGame {

	public ScoreCalculator getCalculator();
	
	public int[] getUndoState();
	
	public int[] getRedoState();
	
	public List<Player> getPlayers();
	
	public void addNewScores(int[] newScore);
}

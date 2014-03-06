package implementations;

import java.util.List;

import framework.GameUpdateListener;
import framework.Player;
import framework.RoundResult;
import framework.ScoreCalculator;
import framework.WhistCalculator;

public class WhistCalculatorImpl implements WhistCalculator {

	public WhistCalculatorImpl(ScoreCalculator score) {
		
	}
	
	@Override
	public void endRound(RoundResult result) {

	}

	@Override
	public List<Player> getPlayers() {
		return null;
	}

	@Override
	public List<Player> getRoundPlayers() {
		return null;
	}

	@Override
	public void registerGameUpdateListener(GameUpdateListener listener) {

	}

}

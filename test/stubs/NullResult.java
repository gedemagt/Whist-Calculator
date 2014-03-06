package stubs;

import java.util.List;
import java.util.Map;

import framework.Player;
import framework.RoundResult;
import framework.enums.Addition;
import framework.enums.CardSuite;

public class NullResult implements RoundResult {

	@Override
	public int getTricks() {
		return 0;
	}

	@Override
	public CardSuite getTrumph() {
		return null;
	}

	@Override
	public int getMelding() {
		return 0;
	}

	@Override
	public Addition getAddition() {
		return null;
	}

	@Override
	public List<Player> getWinners() {
		return null;
	}

	@Override
	public List<Player> getCallers() {
		return null;
	}

	@Override
	public Map<String, String> getExtra() {
		return null;
	}

}

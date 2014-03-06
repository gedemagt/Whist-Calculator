package stubs;

import framework.RoundResult;
import framework.ScoreCalculator;
import framework.WhistCalculator;

public class DoubleScoreCalculator implements ScoreCalculator {

	@Override
	public int[] calculateScore(RoundResult result, WhistCalculator calc) {
		int[] re = new int[4];
		for(int i=0; i<4; i++) {
			re[i] = calc.getRoundPlayers().get(i).getBalance()*2;
		}
		return re;
	}
}

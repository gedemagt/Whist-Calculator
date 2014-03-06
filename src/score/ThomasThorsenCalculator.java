package score;

import framework.Player;
import framework.RoundResult;
import framework.ScoreCalculator;
import framework.WhistCalculator;
import framework.enums.Addition;
import framework.enums.CardSuite;

public class ThomasThorsenCalculator implements ScoreCalculator {

	
	private double V;
	private double O;
	private double U;
	private double D;
	private double M;
	private double G;
	private double B;
	private double C;
	
	public ThomasThorsenCalculator(int ground) {
		this.B = ground;
	}
	
	@Override
	public int[] calculateScore(RoundResult result, WhistCalculator calc) {
		int[] newScore = new int[4];
		for(int i=0; i<4; i++) {
			calculateValues(result, calc.getRoundPlayers().get(i));
			newScore[i] = (int) ((V+O-3/2*U)*D*M*G*B*Math.pow((5/2),(C-8)));
		} 
		return newScore;
	}

	private void calculateValues(RoundResult result, Player p) {
		C = result.getMelding();
		
		D = result.getCallers().contains(p) ? 1 : -1;
		
		if(result.getWinners().size() == 1 && result.getWinners().contains(p)) M = 2;
		else if(result.getWinners().size() != 1 && !result.getWinners().contains(p)) M = 2/3;
		else M = 1;
		
		O = result.getTricks() - result.getMelding();
		
		U = result.getMelding() - result.getTricks();
		
		V = result.getCallers().contains(p) ? 1 : 0;
		
		// Calculate G
		if(result.getTrumph() == CardSuite.NONE || result.getAddition() == Addition.SANS) G = 4;
		else if(result.getAddition() == Addition.HALF) G = 2;
		else {
			if(result.getTrumph() == CardSuite.CLUBS) G = 2;
			else G = 1;
		}
		if(result.getAddition() == Addition.VIP) {
			int vip = Integer.parseInt(result.getExtra().get("vipcount"));
			if(vip == 2) G = 2;
			else if(vip == 3) G = 4;
		}
		
	}



}


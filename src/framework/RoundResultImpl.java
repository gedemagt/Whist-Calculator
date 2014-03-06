package framework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import framework.enums.Addition;
import framework.enums.CardSuite;

public class RoundResultImpl implements RoundResult {

	private int tricks;
	private CardSuite trumph;
	private int melding;
	private Addition addition;
	private List<Player> winners;
	private List<Player> callers;
	private Map<String, String> extra;
	
	
	private RoundResultImpl(RoundResultBuilder builder) {
		this.tricks = builder.tricks;
		this.trumph = builder.trumph;
		this.melding = builder.melding;
		this.addition = builder.addition;
		this.winners = builder.winners;
		this.callers = builder.callers;
		this.extra = builder.extra;
	}


	@Override
	public int getTricks() {
		return tricks;
	}


	@Override
	public CardSuite getTrumph() {
		return trumph;
	}


	@Override
	public int getMelding() {
		return melding;
	}


	@Override
	public Addition getAddition() {
		return addition;
	}


	@Override
	public List<Player> getWinners() {
		return winners;
	}


	@Override
	public List<Player> getCallers() {
		return callers;
	}


	@Override
	public Map<String, String> getExtra() {
		return extra;
	}
	
	public static class RoundResultBuilder {
		
		private int tricks;
		private CardSuite trumph;
		private int melding;
		private Addition addition;
		private List<Player> winners;
		private List<Player> callers;
		private Map<String, String> extra;
		
		public RoundResultBuilder() {
			winners = new ArrayList<Player>();
			callers = new ArrayList<Player>();
			extra = new HashMap<String, String>();
		}
		
		public RoundResultBuilder tricks(int tricks) {
			this.tricks = tricks;
			return this;
		}
		
		public RoundResultBuilder trumph(CardSuite trumph) {
			this.trumph = trumph;
			return this;
		}
		
		public RoundResultBuilder melding(int melding) {
			this.melding = melding;
			return this;
		}
		
		public RoundResultBuilder addition(Addition addition) {
			this.addition = addition;
			return this;
		}
		
		public RoundResultBuilder winner(Player winner) {
			winners.add(winner);
			return this;
		}
		
		public RoundResultBuilder caller(Player caller) {
			callers.add(caller);
			return this;
		}
		
		public RoundResultBuilder extra(String key, String value) {
			extra.put(key, value);
			return this;
		}
		
		public RoundResult build() {
			return new RoundResultImpl(this);
		}
	}
	
}

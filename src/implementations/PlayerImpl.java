package implementations;

import framework.Player;

public class PlayerImpl implements Player {

	private String name;
	private int balance;
	
	public PlayerImpl(String name, int balance) {
		this.name = name;
		this.balance = balance;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getBalance() {
		return balance;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof PlayerImpl) return ((PlayerImpl) o).getName().equals(name);
		else return false;
	}
}

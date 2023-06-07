package com.vending.machine.domain;

public class Coin {
	private CoinType type;
	private int quantity;

	public Coin(CoinType type, int quantity) {
		this.type = type;
		this.quantity = quantity;
	}

	public CoinType getType() {
		return type;
	}

	public void setType(CoinType type) {
		this.type = type;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}

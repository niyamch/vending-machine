package com.vending.machine.domain;

public enum CoinType {
	TEN_ST(10), TWENTY_ST(20), FIFTY_ST(50), ONE_LEV(100), TWO_LEV(200);

    public final int value;

    private CoinType(int value) {
        this.value = value;
    }
}

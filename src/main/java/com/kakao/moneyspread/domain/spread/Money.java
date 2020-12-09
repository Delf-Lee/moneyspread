package com.kakao.moneyspread.domain.spread;

import javax.persistence.Entity;

public class Money {
	private int amount;

	private Money(int amount) {
		this.amount = amount;
	}

	public static Money of(int amount) {
		return new Money(amount);
	}
}

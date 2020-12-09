package com.kakao.moneyspread.domain.spread.token;

import java.util.Objects;

public class SpreadToken {
	private final static TokenGenerator tokenGenerator = SimpleTokenGenerator.getInstance();
	private String value;

	public SpreadToken() {
		this.value = tokenGenerator.generateToken();
	}

	public String getValue() {
		return value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		return Objects.equals(value, o);
	}
}
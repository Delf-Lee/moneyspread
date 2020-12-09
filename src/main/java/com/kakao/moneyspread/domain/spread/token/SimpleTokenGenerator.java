package com.kakao.moneyspread.domain.spread.token;

import lombok.NoArgsConstructor;

import java.util.Random;

@NoArgsConstructor
public class SimpleTokenGenerator implements TokenGenerator {
	private final static int ALPHABET_SIZE = 26;
	private final static int TOKEN_LENGTH = 3;

	private static class LazyHolder {
		private static final SimpleTokenGenerator INSTANCE = new SimpleTokenGenerator();
	}

	static SimpleTokenGenerator getInstance() {
		return LazyHolder.INSTANCE;
	}

	@Override
	public String generateToken() {
		String result = "";
		for (int i = 0; i < TOKEN_LENGTH; i++) {
			result += getRandomLetter();
		}
		return result;
	}

	private char getRandomLetter() {
		Random random = new Random();
		return (char) ('A' + random.nextInt(ALPHABET_SIZE));
	}
}

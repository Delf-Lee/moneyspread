package com.kakao.moneyspread.util;


public class Random {
	private final static java.util.Random random = new java.util.Random();
	public static int someInt() {
		return random.nextInt();
	}
}

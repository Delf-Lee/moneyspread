package com.kakao.moneyspread.fixture;


import com.kakao.moneyspread.domain.spread.Spread;
import com.kakao.moneyspread.domain.spread.strategy.RandomStrategy;
import com.kakao.moneyspread.domain.spread.strategy.SpreadStrategy;
import org.junit.jupiter.api.BeforeEach;

public abstract class SpreadFixture {
	protected final static int TEST_MONEY = 10_000;
	protected final static int TEST_PEOPLE = 7;
	protected final static SpreadStrategy TEST_STRATEGY = new RandomStrategy();

	protected Spread simpleSpread;

	@BeforeEach
	public void setUp() {
		simpleSpread = Spread.builder()
				.amount(TEST_MONEY)
				.people(TEST_PEOPLE)
				.build();
	}

	protected Spread generateNewSimpleSpread() {
		return Spread.builder()
				.amount(TEST_MONEY)
				.people(TEST_PEOPLE)
				.build();
	}

}

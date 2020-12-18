package com.kakao.moneyspread.service;

import com.kakao.moneyspread.domain.spread.Spread;
import com.kakao.moneyspread.domain.spread.SpreadRepository;
import com.kakao.moneyspread.domain.spread.strategy.RandomStrategy;
import com.kakao.moneyspread.domain.spread.strategy.SpreadStrategy;
import com.kakao.moneyspread.domain.spread.token.SpreadToken;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SpreadService {

	private final SpreadRepository spreadRepository;

	private static final SpreadStrategy DEFAULT_STRATEGY = new RandomStrategy();

	public SpreadToken createSpread(int money, int people, SpreadStrategy strategy) {
		Spread spread = Spread.builder()
				.amount(money)
				.people(people)
				.strategy(strategy)
				.build();
		return spreadRepository.save(spread).getToken();
	}

	public SpreadToken createSpread(int money, int people) {
		return createSpread(money, people, DEFAULT_STRATEGY);
	}
}
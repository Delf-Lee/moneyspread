package com.kakao.moneyspread.service;

import com.kakao.moneyspread.controller.dto.SpreadDto;
import com.kakao.moneyspread.domain.spread.Spread;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
//@AllArgsConstructor
public class SpreadService {

//	private final SpreadRepository spreadRepository;
//	private static final SpreadStrategy DEFAULT_STRATEGY = new BalanceStrategy();

	@PostMapping
	public String createSpread(SpreadDto spreadDto) {
		Spread spread = Spread.builder()
				.amount(spreadDto.getMoney())
				.people(spreadDto.getPeople())
//				.strategy(DEFAULT_STRATEGY)
				.build();
		return null;
//		return spreadRepository.save(spread).getToken();
	}
}

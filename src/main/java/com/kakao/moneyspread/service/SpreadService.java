package com.kakao.moneyspread.service;

import com.kakao.moneyspread.controller.dto.SpreadDto;
import com.kakao.moneyspread.domain.spread.Spread;
import com.kakao.moneyspread.domain.spread.SpreadRepository;
import com.kakao.moneyspread.domain.spread.strategy.SpreadStrategy;
import com.mysql.jdbc.BalanceStrategy;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;

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


	public static void main(String[] args) {
		System.out.println(new SpreadService().solution(new int[][]{{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}}));
	}

	public int solution(int[][] land) {
		for (int j = 0; j < land.length; j++) {
			for (int i = 0; i < land[j].length; i++) {
				if (j == 0) continue;
				land[j][i] += getMaxExcept(land[j - 1], i);
			}
		}

		return Arrays.stream(land[land.length - 1]).max().getAsInt();
	}

	private int getMaxExcept(int[] arr, int index) {
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			if (i == index) {
				continue;
			}
			max = Math.max(max, arr[i]);
		}
		return max;
	}
}

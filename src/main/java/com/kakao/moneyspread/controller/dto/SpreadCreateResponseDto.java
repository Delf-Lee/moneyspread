package com.kakao.moneyspread.controller.dto;

import com.kakao.moneyspread.domain.spread.token.SpreadToken;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class SpreadCreateResponseDto {
	private SpreadToken token;
}

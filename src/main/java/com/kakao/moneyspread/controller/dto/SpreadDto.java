package com.kakao.moneyspread.controller.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class SpreadDto {
	@NotNull
	private int money;
	@NotNull
	private int people;
}

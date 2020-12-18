package com.kakao.moneyspread.controller;

import com.kakao.moneyspread.controller.dto.SpreadCreateRequestDto;
import com.kakao.moneyspread.controller.dto.SpreadCreateResponseDto;
import com.kakao.moneyspread.domain.spread.token.SpreadToken;
import com.kakao.moneyspread.service.SpreadService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/spread")
@AllArgsConstructor
public class SpreadController {

	private final SpreadService spreadService;

	@PostMapping
	public ResponseEntity<SpreadCreateResponseDto> createSpread(@RequestBody SpreadCreateRequestDto request) {
		SpreadToken token = spreadService.createSpread(request.getMoney(), request.getPeople());
		SpreadCreateResponseDto response = SpreadCreateResponseDto.builder().token(token).build();
		return ResponseEntity.ok(response);
	}
}

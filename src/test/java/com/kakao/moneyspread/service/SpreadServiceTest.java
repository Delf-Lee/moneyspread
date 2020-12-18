package com.kakao.moneyspread.service;

import com.kakao.moneyspread.domain.spread.Spread;
import com.kakao.moneyspread.domain.spread.SpreadRepository;
import com.kakao.moneyspread.fixture.SpreadFixture;
import com.kakao.moneyspread.util.Random;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SpreadServiceTest extends SpreadFixture {

	@InjectMocks
	private SpreadService spreadService;

	@Mock
	private SpreadRepository spreadRepository;

	@Test
	@DisplayName("Spread를 생성할 수 있다")
	void createSpreadTest() {
		when(spreadRepository.save(any(Spread.class))).thenReturn(simpleSpread);
		spreadService.createSpread(Random.someInt(), Random.someInt());
		verify(spreadRepository).save(any(Spread.class));
	}
}

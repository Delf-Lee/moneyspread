package com.kakao.moneyspread.domain.spread;

import com.kakao.moneyspread.fixture.SpreadFixture;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class SpreadRepositoryTest extends SpreadFixture {

	private SpreadRepository spreadRepository;

	@Test
	void createSpreadTest() {
		int size = (int) spreadRepository.count();
		spreadRepository.save(simpleSpread);
		assertThat(size).isEqualTo(size + 1);
	}
}

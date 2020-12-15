package com.kakao.moneyspread.domain.spread;

import com.kakao.moneyspread.fixture.SpreadFixture;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.transaction.Transactional;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ExtendWith(MockitoExtension.class)
class SpreadRepositoryTest extends SpreadFixture {

	@Autowired
	private SpreadRepository spreadRepository;

	@Test
	void testImportSampleData() {
		assertThat(spreadRepository.count()).isEqualTo(5);
	}

	@Test
	@Transactional
	void createSpreadTest() {
		int size = (int) spreadRepository.count();
		spreadRepository.save(simpleSpread);
		assertThat(spreadRepository.count()).isEqualTo(size + 1);
	}

	@Test
	@Transactional
	void createdTimeTest() {
		LocalDateTime now = LocalDateTime.now();
		Spread spread = generateNewSimpleSpread();
		assertThat(spread.getCreateAt()).isAfter(now).isBefore(LocalDateTime.now());
	}
}

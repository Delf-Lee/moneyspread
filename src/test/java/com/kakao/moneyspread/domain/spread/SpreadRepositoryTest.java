package com.kakao.moneyspread.domain.spread;

import com.kakao.moneyspread.fixture.SpreadFixture;
import org.junit.jupiter.api.DisplayName;
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
	@DisplayName("Spread 샘플 데이터 로드 테스트")
	void sampleDataLoadTest() {
		assertThat(spreadRepository.count()).isEqualTo(1);
	}

	@Test
	@Transactional
	@DisplayName("Spread 객체를 저장할 수 있다")
	void createSpreadTest() {
		int size = (int) spreadRepository.count();
		spreadRepository.save(simpleSpread);
		assertThat(spreadRepository.count()).isEqualTo(size + 1);
	}

	@Test
	@Transactional
	@DisplayName("Spread 객체를 저장할 때 시간이 기록된다")
	void createdTimeTest() {
		LocalDateTime before = LocalDateTime.now();
		long id = spreadRepository.save(generateNewSimpleSpread()).getId();
		LocalDateTime after = LocalDateTime.now();

		Spread spread = spreadRepository.getOne(id);
		assertThat(spread.getCreateAt()).isAfter(before).isBefore(after);
	}
}

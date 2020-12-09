package com.kakao.moneyspread.domain.spread.token;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleTokenGeneratorTest {

	private SimpleTokenGenerator tokenGenerator = new SimpleTokenGenerator();

	@Test
	@DisplayName("세자리 문자을 생성한다")
	void generateTokenTest() {
		String tokenString = tokenGenerator.generateToken();
		assertThat(tokenString.length()).isEqualTo(3);
	}
}

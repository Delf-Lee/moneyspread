package com.kakao.moneyspread.domain.spread;

import com.kakao.moneyspread.domain.spread.token.SpreadToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpreadRepository extends JpaRepository<Spread, Long> {
	void findByToken(SpreadToken token);
}

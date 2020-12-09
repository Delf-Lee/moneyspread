package com.kakao.moneyspread.domain.spread;

import com.kakao.moneyspread.domain.spread.token.SpreadToken;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Spread {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	private String token;

	@Column
	private int amount;

	@Column
	private int people;

	@Builder
	public Spread(int amount, int people) {
		this.amount = amount;
		this.people = people;
		this.token = new SpreadToken().getValue();
	}

	public String getToken() {
		return token;
	}
}
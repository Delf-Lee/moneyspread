package com.kakao.moneyspread.domain.user;

import com.kakao.moneyspread.domain.spread.Spread;

import javax.persistence.*;

@Entity
public class UserGettingMoney {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "spread_id")
	private Spread spread;

	@Column(nullable = false)
	private int money;
}

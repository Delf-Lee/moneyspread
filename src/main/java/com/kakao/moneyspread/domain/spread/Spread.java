package com.kakao.moneyspread.domain.spread;

import com.kakao.moneyspread.domain.chatroom.ChatRoom;
import com.kakao.moneyspread.domain.spread.strategy.SpreadStrategy;
import com.kakao.moneyspread.domain.spread.token.SimpleTokenGenerator;
import com.kakao.moneyspread.domain.spread.token.SpreadToken;
import com.kakao.moneyspread.domain.spread.token.TokenGenerator;
import com.kakao.moneyspread.domain.user.User;
import com.kakao.moneyspread.domain.user.UserGettingMoney;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Spread {

	private final static TokenGenerator TOKEN_GENERATOR = new SimpleTokenGenerator();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@CreatedDate
	private LocalDateTime createAt;

	@Lob
	private SpreadToken token;

	@Column
	private int people;

	@Column
	private int money;

	@Lob
	private SpreadStrategy strategy;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User host;

	@ManyToOne
	@JoinColumn(name = "room_id")
	private ChatRoom room;

	@OneToMany(mappedBy = "user")
	private List<UserGettingMoney> userGettringMoney;

	@Builder
	public Spread(int amount, int people, SpreadStrategy strategy) {
		this.money = amount;
		this.people = people;
		this.token = new SpreadToken();
		this.strategy = strategy;
	}
}
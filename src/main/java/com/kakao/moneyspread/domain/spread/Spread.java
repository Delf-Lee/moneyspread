package com.kakao.moneyspread.domain.spread;

import com.kakao.moneyspread.domain.user.UserGettingMoney;
import com.kakao.moneyspread.domain.chatroom.ChatRoom;
import com.kakao.moneyspread.domain.spread.token.SpreadToken;
import com.kakao.moneyspread.domain.user.User;
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
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String token;

	@Column
	private int amount;

	@Column
	private int people;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User host;

	@ManyToOne
	@JoinColumn(name = "room_id")
	private ChatRoom room;

	@OneToMany(mappedBy = "user")
	private List<UserGettingMoney> userGettringMoney;

	@CreatedDate
	private LocalDateTime createAt;

	@Builder
	public Spread(int amount, int people) {
		this.amount = amount;
		this.people = people;
		this.token = new SpreadToken().getValue();
	}
}
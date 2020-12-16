package com.kakao.moneyspread.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@ToString
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private Long xUserId;

	@OneToMany(mappedBy = "user")
	private List<UserInChatRoom> rooms;

	@Builder
	public User(Long xUserId) {
		this.xUserId = xUserId;
	}
}

package com.kakao.moneyspread.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue
	private int id;

	@Column
	private int xUserId;

	@Builder
	public User(int xUserId) {
		this.xUserId = xUserId;
	}
}

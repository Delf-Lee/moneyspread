package com.kakao.moneyspread.domain.user;

import com.kakao.moneyspread.domain.chatroom.ChatRoom;

import javax.persistence.*;

@Entity
public class UserInRoom {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "chatroom_id")
	private ChatRoom chatRoom;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
}

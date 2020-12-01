package com.kakao.moneyspread.domain.chatroom;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "chatroom")
@Getter
@NoArgsConstructor
public class ChatRoom {
	@Id
	@GeneratedValue
	@Column(name = "chatroom_id")
	private int id;

	@Column
	private int xRoomId;

	@Builder
	public ChatRoom(int xRoomId) {
		this.xRoomId = xRoomId;
	}
}

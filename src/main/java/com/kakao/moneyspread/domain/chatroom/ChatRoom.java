package com.kakao.moneyspread.domain.chatroom;

import com.kakao.moneyspread.domain.user.UserInChatRoom;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class ChatRoom {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private Long xRoomId;

	@OneToMany(mappedBy = "chatRoom")
	private List<UserInChatRoom> usersInChatRoom;

	@Builder
	public ChatRoom(Long xRoomId) {
		this.xRoomId = xRoomId;
	}
}

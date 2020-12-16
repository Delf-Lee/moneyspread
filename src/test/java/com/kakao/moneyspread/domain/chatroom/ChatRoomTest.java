package com.kakao.moneyspread.domain.chatroom;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@DataJpaTest
@ExtendWith(MockitoExtension.class)
class ChatRoomTest {

	@Autowired
	private ChatRoomRepository chatRoomRepository;

	@Test
	@DisplayName("ChatRoom 샘플 데이터 로드 테스트")
	void sampleDataLoadTest() {
		assertThat(chatRoomRepository.count()).isEqualTo(3);
	}
}

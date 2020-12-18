package com.kakao.moneyspread.controller;


import com.kakao.moneyspread.controller.dto.SpreadCreateRequestDto;
import com.kakao.moneyspread.service.SpreadService;
import com.kakao.moneyspread.util.JsonObjectMapper;
import com.kakao.moneyspread.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class SpreadControllerTest {

	@InjectMocks
	private SpreadController spreadController;

	@Mock
	private SpreadService adminService;

	private static MockMvc mockMvc;

	@BeforeEach
	void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(spreadController)
				.build();
	}

	@Test
	@DisplayName("Spread 생성 요청이 성공한다")
	void requestCreateSpreadTest() throws Exception {
		SpreadCreateRequestDto dto = SpreadCreateRequestDto.builder()
				.build();

		String requestJsonBody = JsonObjectMapper.mapper.writeValueAsString(dto);
		System.out.println(requestJsonBody);
		mockMvc.perform(post("/api/spread")
				.contentType(MediaType.APPLICATION_JSON)
				.content(requestJsonBody))
				.andExpect(status().isOk());
	}
}

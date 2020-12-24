package com.entelgy.demo.expose.web;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import com.entelgy.demo.business.model.dto.CommentDto;
import com.entelgy.demo.business.model.response.ResponseGetComments;
import com.entelgy.demo.business.service.DemoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
public class DemoControllerTest {

	@InjectMocks
	DemoController controller;

	@Mock
	DemoService demoService;

	private MockMvc mockMvc;

	private final String pathBase = "/application/entelgy/v1";

	@BeforeEach
	public void setUp() {
		this.mockMvc = standaloneSetup(this.controller).addPlaceholderValue("application.entelgy.api.path", pathBase)
				.build();
	}

	//
	private static final ObjectMapper mapper;

	static {
		mapper = new ObjectMapper();
		mapper.findAndRegisterModules();
	}

	public static <T> String writeDataToJson(T value) throws JsonProcessingException {
		return mapper.writeValueAsString(value);
	}
	//

	@Test
	public void whenSourcesId_thenShouldBeSuccessful() throws Exception {
		Mockito.when(demoService.getComment()).thenReturn(buildResponseGetComments());

		MvcResult mvcResult = mockMvc
				.perform(MockMvcRequestBuilders.post(pathBase.concat("/comments")).accept(MediaType.APPLICATION_JSON)
						.content(writeDataToJson(buildResponseGetComments())))
				.andDo(MockMvcResultHandlers.print()).andReturn();

		Assertions.assertEquals(mvcResult.getResponse().getStatus(), HttpStatus.OK.value());
	}

	private ResponseGetComments buildResponseGetComments() {
		return ResponseGetComments.builder().data(buildListComments()).build();
	}

	private List<CommentDto> buildListComments() {
		List<CommentDto> list = new ArrayList();

		list.add(buildCommentDto(1, 1, "luis1@gmail.com"));
		list.add(buildCommentDto(2, 2, "luis2@gmail.com"));
		list.add(buildCommentDto(3, 3, "luis3@gmail.com"));
		return list;
	}

	private CommentDto buildCommentDto(int postId, int id, String email) {
		return CommentDto.builder().id(id).postId(postId).email(email).build();
	}

}

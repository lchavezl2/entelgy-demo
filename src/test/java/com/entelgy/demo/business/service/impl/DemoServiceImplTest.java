package com.entelgy.demo.business.service.impl;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.entelgy.demo.business.client.typicode.CommentsClient;
import com.entelgy.demo.business.model.Comment;
import com.entelgy.demo.business.model.dto.CommentDto;
import com.entelgy.demo.business.model.response.ResponseGetComments;

@RunWith(MockitoJUnitRunner.class)
public class DemoServiceImplTest {

	@InjectMocks
	DemoServiceImpl demoServiceImpl;

	@Mock
	CommentsClient commentsClient;

	@Test
	public void whenGetComments_thenShouldBySuccessful() {

		Mockito.when(commentsClient.getComment())
		.thenReturn(buildListComments());

		ResponseGetComments service = demoServiceImpl.getComment();
		List<CommentDto> comments = service.getData();
		
		assertEquals("luis1@gmail.com", comments.get(0).getEmail());
		assertEquals("luis2@gmail.com", comments.get(1).getEmail());
		assertEquals("luis3@gmail.com", comments.get(2).getEmail());
	}

	private Comment buildComment(int postId, int id, String email) {
		return Comment.builder()
				.id(id)
				.postId(postId)
				.email(email)
				.build();
	}

	private List<Comment> buildListComments() {
		List<Comment> list = new ArrayList();

		list.add(buildComment(1, 1, "luis1@gmail.com"));
		list.add(buildComment(2, 2, "luis2@gmail.com"));
		list.add(buildComment(3, 3, "luis3@gmail.com"));
		return list;
	}

}

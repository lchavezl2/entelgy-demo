package com.entelgy.demo.business.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entelgy.demo.business.client.typicode.CommentsClient;
import com.entelgy.demo.business.model.dto.CommentDto;
import com.entelgy.demo.business.model.response.ResponseGetComments;
import com.entelgy.demo.business.service.DemoService;

@Service
public class DemoServiceImpl implements DemoService {

	@Autowired
	CommentsClient commentsClient;

	/**
	 * Gets the comment.
	 *
	 * @return the comment
	 */
	@Override
	public ResponseGetComments getComment() {
		
		List<CommentDto> list =  commentsClient.getComment()
				.stream()
				.map(comment -> CommentDto.builder()
						.postId(comment.getPostId())
						.id(comment.getId())
						.email(comment.getEmail())
						.build())
				.collect(Collectors.toList());
		
		return ResponseGetComments.builder()
				.data(list)
				.build();
				
	}

}

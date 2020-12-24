package com.entelgy.demo.business.client.typicode.impl;

import static com.entelgy.demo.util.constants.Constant.URL_COMMENTS;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.entelgy.demo.business.client.typicode.CommentsClient;
import com.entelgy.demo.business.model.Comment;

/**
 * The Class CommentsClientImpl.
 */
@Component
public class CommentsClientImpl implements CommentsClient {

	/**
	 * Gets the comment.
	 *
	 * @return the comment
	 */
	@Override
	public List<Comment> getComment() {

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Comment[]> response = restTemplate.getForEntity(URL_COMMENTS, Comment[].class);

		return Arrays.asList(response.getBody());
	}

}

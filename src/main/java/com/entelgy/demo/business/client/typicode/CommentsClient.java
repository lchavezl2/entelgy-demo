package com.entelgy.demo.business.client.typicode;

import java.util.List;

import com.entelgy.demo.business.model.Comment;

/**
 * The Interface Comments.
 */
public interface CommentsClient {
	
	/**
	 * Gets the comments.
	 *
	 * @return the comments
	 */
	List<Comment> getComment();

}

package com.entelgy.demo.business.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * The Class Comments.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Generated
public class Comment {
	
	/** The post id. */
	private int postId;
	
	/** The id. */
	private int id;
	
	/** The name. */
	private String name;
	
	/** The email. */
	private String email;
	
	/** The body. */
	private String body;
}

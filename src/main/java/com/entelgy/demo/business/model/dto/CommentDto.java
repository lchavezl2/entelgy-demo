package com.entelgy.demo.business.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Generated
public class CommentDto {

	/** The post id. */
	private int postId;

	/** The id. */
	private int id;

	/** The email. */
	private String email;

}

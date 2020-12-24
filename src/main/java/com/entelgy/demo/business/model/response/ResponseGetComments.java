package com.entelgy.demo.business.model.response;

import java.util.List;

import com.entelgy.demo.business.model.dto.CommentDto;

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
public class ResponseGetComments {
	
	List<CommentDto> data;

}

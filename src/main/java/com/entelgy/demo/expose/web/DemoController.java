package com.entelgy.demo.expose.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.entelgy.demo.business.model.response.ResponseGetComments;
import com.entelgy.demo.business.service.DemoService;

@RestController
@RequestMapping("${application.entelgy.api.path}")
public class DemoController {

	DemoService demoService;

	public DemoController(DemoService demoService) {
		this.demoService = demoService;
	}

	@PostMapping(value = "/comments", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseGetComments getComment() {
		return demoService.getComment();
	}
}

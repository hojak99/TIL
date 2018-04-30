package com.kjh.hojak;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {
	
	/**
	 * 기존의 어노테이션을 사용한 컨트롤러 메소드
	 * 
	 * @return
	 */
	@PostMapping(path="/", consumes = {MediaType.APPLICATION_JSON_VALUE, "!application/xml"},
			produces = MediaType.TEXT_PLAIN_VALUE, headers = "X-Custom=Foo", params = "a!=alpha")
	public String example() {
		return "Hello World";
	}
}

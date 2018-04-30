package com.kjh.hojak;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
	
	/**
	 * 기존의 어노테이션을 이용한 컨트롤러 메소드
	 * 
	 * @return
	 */
	@GetMapping("/")
	public String welcome() {
		return "Hello World";
	}
}

package com.kjh.hojak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kjh.hojak.domain.Board;
import com.kjh.hojak.domain.User;
import com.kjh.hojak.repository.UserRepository;
import com.kjh.hojak.service.BoardService;

@RestController
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	
	@PostMapping("/board")
	public void createBoard(@RequestBody Board board) throws Exception {
		boardService.create(board);
	}
	
	@PostMapping("/user")
	public void createUser(@RequestBody User user) throws Exception {
		
	}
}

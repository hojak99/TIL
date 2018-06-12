package com.kjh.hojak.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kjh.hojak.domain.Board;
import com.kjh.hojak.domain.User;
import com.kjh.hojak.repository.UserRepository;
import com.kjh.hojak.service.BoardService;
import com.kjh.hojak.service.UserService;

@RestController
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/board")
	public void createBoard(@RequestBody Board board) throws Exception {
		boardService.create(board);
	}
	
	@GetMapping("/board")
	public List<Board> getAllBoard(Pageable pageable) throws Exception {
		return boardService.findAll(pageable);
	}
	
	
	@PostMapping("/user")
	public void createUser(@RequestBody User user) throws Exception {
		userService.create(user);
	}
}

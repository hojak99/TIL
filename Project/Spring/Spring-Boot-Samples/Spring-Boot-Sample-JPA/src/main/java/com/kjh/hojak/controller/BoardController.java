package com.kjh.hojak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kjh.hojak.domain.Board;
import com.kjh.hojak.service.BoardService;

@RestController
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@PostMapping("/create")
	public void board(@RequestBody Board board) throws Exception {
		System.out.println(board.toString());
		
		boardService.create(board);
	}
}

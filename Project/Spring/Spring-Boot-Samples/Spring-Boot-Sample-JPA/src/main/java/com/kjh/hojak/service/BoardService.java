package com.kjh.hojak.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kjh.hojak.domain.Board;
import com.kjh.hojak.repository.BoardRepository;

@Service
public class BoardService {

	@Autowired
	BoardRepository boardRepository;
	
	@Transactional
	public List<Board> findAll(Pageable pageable) {
		return boardRepository.findAll(pageable).stream().collect(Collectors.toList());
	}
	
	@Transactional
	public List<Board> findByWriterId(String writerId, Pageable pageable) throws Exception {
		Optional.ofNullable(writerId)
			.orElseThrow(() -> new Exception("findByWriterId() to writer_id is Null"));
		
		return boardRepository.findByWriterId(writerId.trim(), pageable).stream().collect(Collectors.toList());
	}
	
	@Transactional
	public void create(Board board) throws Exception {
		Optional.ofNullable(board)
			.filter(temp -> temp.getTitle() != null)
			.filter(temp -> temp.getContent() != null)
			.orElseThrow(() -> new Exception("Create Board Exception"));
		
		boardRepository.save(board);
	}
	
}

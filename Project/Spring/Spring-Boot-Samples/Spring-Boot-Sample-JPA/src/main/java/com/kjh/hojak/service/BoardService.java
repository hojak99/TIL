package com.kjh.hojak.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
	
	public List<Board> findAll(Pageable pageable) {
		return boardRepository.findAll(pageable).stream().collect(Collectors.toList());
	}
	
	public List<Board> findByWriterId(String writer_id, Pageable pageable) throws Exception {
		Optional.ofNullable(writer_id)
			.orElseThrow(() -> new Exception("findByWriterId() to writer_id is Null"));
		
		return boardRepository.findByWriterId(writer_id.trim(), pageable).stream().collect(Collectors.toList());
	}
	
}

package com.kjh.hojak.repository;

import java.util.stream.Stream;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.kjh.hojak.domain.Board;

public interface BoardRepository extends JpaRepository<Board, String>{
	
	/**
	 * writer_id 로 Board 찾기
	 * @return {@link Page}
	 */
	Page<Board> findByWriterId(String writerId, Pageable pageable);
	
	
	/**
	 * 모든 Board 가져오기
	 * @return {@link Page}
	 */
	Page<Board> findAll(Pageable pageable);
}

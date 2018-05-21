package com.kjh.hojak.domain.repository;

import java.util.List;
import java.util.Optional;

import com.kjh.hojak.domain.Board;

public interface BoardRepository {
	
	/**
	 * writer_id 로 Board 찾기
	 * @return {@link Optional}
	 */
	Optional<Board> getBoardToWriterId(String writer_id);
	
	
	/**
	 * 모든 Board 가져오기
	 * @return {@link List}
	 */
	List<Optional<Board>> getAllBoard();
}

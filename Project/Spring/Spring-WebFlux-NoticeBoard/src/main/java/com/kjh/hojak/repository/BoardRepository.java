package com.kjh.hojak.repository;

import org.springframework.stereotype.Repository;

import com.kjh.hojak.model.Board;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

@Repository
public interface BoardRepository extends ReactiveCrudRepository<Board, String>{

}

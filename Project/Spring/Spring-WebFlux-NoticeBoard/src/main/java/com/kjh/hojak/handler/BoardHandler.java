package com.kjh.hojak.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.kjh.hojak.model.Board;
import com.kjh.hojak.repository.BoardRepository;

import reactor.core.publisher.Mono;

@Component
public class BoardHandler {

    @Autowired
    BoardRepository boardRepository;

    public Mono<ServerResponse> fetchAll(ServerRequest request) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(boardRepository.findAll(), Board.class);
    }

    public Mono<ServerResponse> save(Mono<Board> request) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(request.flatMap(boardRepository::save), Board.class);
    }
}

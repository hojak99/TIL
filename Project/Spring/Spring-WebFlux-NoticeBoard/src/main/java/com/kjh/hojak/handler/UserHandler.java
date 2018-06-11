package com.kjh.hojak.handler;

import com.kjh.hojak.model.User;
import com.kjh.hojak.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

@Component
public class UserHandler {

    @Autowired
    UserRepository userRepository;

    public Mono<ServerResponse> fetchAll(ServerRequest request) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(userRepository.findAll(), User.class);
    }

    public Mono<ServerResponse> fetch(ServerRequest request) {
        final String writerId = String.valueOf(request.pathVariable("writerId"));

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(userRepository.findByWriterId(writerId), User.class)
    }

    public Mono<ServerResponse> save(Mono<User> request) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(
                        request.flatMap(userRequest ->
                                userRepository.findByWriterId(userRequest.getWriterId())
                                        .flatMap(user -> Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "Exist user")))
                                        // element 가 있을 때 true, 없을 때 false
                                        .hasElement().flatMap(isEmpty -> userRepository.save(userRequest))
                        ), User.class);
    }
}

package com.kjh.hojak.handler;

import com.kjh.hojak.model.User;
import com.kjh.hojak.repository.UserRepository;
import com.mongodb.connection.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuples;

@Component
public class UserHandler {

    @Autowired
    UserRepository userRepository;

    public Mono<ServerResponse> fetchAll(ServerRequest request) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(userRepository.findAll(), User.class);
    }

    public Mono<ServerResponse> save(Mono<User> request) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(
                    request.flatMap(userRequest ->
                         userRepository.findByWriterId(userRequest.getWriterId())
                                .flatMap(user -> Mono.just("exist user"))
                                .hasElement().flatMap(isEmpty -> {
                                    if(isEmpty == false) {
                                        System.out.println(isEmpty);
                                        return userRepository.save(userRequest);
                                    } else {
                                        new ResponseStatusException(HttpStatus.BAD_REQUEST, "Exist user");
                                        return Mono.empty();
                                    }
                                })
                         ), User.class );
    }
}

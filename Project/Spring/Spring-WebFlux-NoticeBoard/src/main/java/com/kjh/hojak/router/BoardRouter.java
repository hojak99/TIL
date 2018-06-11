package com.kjh.hojak.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

import com.kjh.hojak.handler.BoardHandler;
import com.kjh.hojak.model.Board;

@Configuration
public class BoardRouter {
	@Bean
	RouterFunction<ServerResponse> boardApis(BoardHandler handler) {
		return RouterFunctions.
				route(GET("/boards").and(accept(MediaType.APPLICATION_JSON)),
					handler::fetchAll)

				.andRoute(POST("/board").and(accept(MediaType.APPLICATION_JSON)), 
						request -> handler.save(request.bodyToMono(Board.class)));
	}
}

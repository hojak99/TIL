package com.kjh.hojak.router;


import com.kjh.hojak.handler.UserHandler;
import com.kjh.hojak.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class UserRouter {

    @Bean
    RouterFunction<ServerResponse> userApis(UserHandler handler) {
        return RouterFunctions
                .route(GET("/users").and(accept(MediaType.APPLICATION_JSON)),
                        handler::fetchAll)

                .andRoute(POST("/user").and(accept(MediaType.APPLICATION_JSON)),
                        request -> handler.save(request.bodyToMono(User.class)));
    }
}

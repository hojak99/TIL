package com.kjh.hojak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;

@SpringBootApplication
public class SpringWebFluxApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebFluxApplication.class, args);
	}


	
	/**
	 * 새로운 방식의 routing 방법. 좀 더 functional 한 프로그래밍을 할 수 있다. 
	 * 쉽게 생각하면 URL을 명시하는 RouterFunction 과 URL과 로직을 연결하는 HandlerFunction 으로 나눌 수 있다.
	 * 
	 * @param echoHandler
	 * @return
	 */
	@Bean
	public RouterFunction<ServerResponse> monoRouterFunction(EchoHandler echoHandler) {
		return route(POST("/echo"), echoHandler::echo);
	}
}

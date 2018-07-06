package com.kjh.hojak;

import com.kjh.hojak.client.GreetingService;
import com.kjh.hojak.client.SimpleGreetingService;
import com.kjh.hojak.echo.DefaultEchoService;
import com.kjh.hojak.echo.EchoService;
import com.kjh.hojak.echo.EchoWebSocketHandler;
import com.kjh.hojak.reverse.ReverseWebSocketEndpoint;
import com.kjh.hojak.snake.SnakeWebSocketHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.handler.PerConnectionWebSocketHandler;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@Configuration
@EnableAutoConfiguration
@EnableWebSocket
@SpringBootApplication
public class SpringBootWebSocketApplication extends SpringBootServletInitializer
    implements WebSocketConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebSocketApplication.class, args);
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(echoWebSocketHandler(), "/echo").withSockJS();
        registry.addHandler(snakeWebSocketHandler(), "/snake").withSockJS();
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder) {
        return applicationBuilder.sources(SpringBootWebSocketApplication.class);
    }

    @Bean
    public EchoService echoService() {
        return new DefaultEchoService("Did you say \"%s\"?");
    }

    @Bean
    public GreetingService greetingService() {
        return new SimpleGreetingService();
    }

    @Bean
    public WebSocketHandler echoWebSocketHandler() {
        return new EchoWebSocketHandler(echoService());
    }

    @Bean
    public WebSocketHandler snakeWebSocketHandler() {
        return new PerConnectionWebSocketHandler(SnakeWebSocketHandler.class);
    }

    @Bean
    public ReverseWebSocketEndpoint reverseWebSocketEndPoint() {
        return new ReverseWebSocketEndpoint();
    }

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}

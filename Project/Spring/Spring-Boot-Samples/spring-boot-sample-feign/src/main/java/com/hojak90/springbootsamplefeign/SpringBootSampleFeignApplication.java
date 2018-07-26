package com.hojak90.springbootsamplefeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableFeignClients
@EnableWebMvc
@SpringBootApplication
public class SpringBootSampleFeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootSampleFeignApplication.class, args);
    }
}

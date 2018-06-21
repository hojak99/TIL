package com.kjh.hojak.client;

public class SimpleGreetingService implements GreetingService {

    @Override
    public String getGreeting() {
        return "Hello world";
    }
}

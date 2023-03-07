package com.example.springcloudfntutorial;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@Configuration
public class functions {
    /**
     * Accepts input and returns output (GET/POST)
     * HTTP GET http://localhost:8080/uppercase/abc
     * @return
     */
    @Bean
    public Function<String,String> uppercase() {
        return value -> value.toUpperCase();
    }

    /**
     * Returns output (GET)
     * HTTP GET http://localhost:8080/hello
     * @return
     */
    @Bean
    public Supplier<String> hello() {
        return () -> "Hello, Spring Cloud Function!";
    }

    /**
     * HTTP POST http://localhost:8080/add
     * @return
     */
    @Bean
    public  Function<Subscriber, Subscriber> add() {
        return value -> value;
    }

    /**
     * HTTP POST http://localhost:8080/consume
     * @return
     */
    @Bean
    public Consumer<Subscriber> consume() {
        return value -> {
            System.out.println(value.toString());
        };
    }
}

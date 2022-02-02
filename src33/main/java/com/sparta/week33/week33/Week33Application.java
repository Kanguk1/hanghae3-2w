package com.sparta.week33.week33;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Week33Application {

    public static void main(String[] args) {
        SpringApplication.run(Week33Application.class, args);
    }
}
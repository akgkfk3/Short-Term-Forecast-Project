package com.bigs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class InquireApplication {

    public static void main(String[] args) {
        SpringApplication.run(InquireApplication.class, args);
    }
}

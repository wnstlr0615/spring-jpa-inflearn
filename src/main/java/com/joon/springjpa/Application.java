package com.joon.springjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(repositoryImplementationPostfix="Impl")  //  커스텀 구현체 접미어 변경
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

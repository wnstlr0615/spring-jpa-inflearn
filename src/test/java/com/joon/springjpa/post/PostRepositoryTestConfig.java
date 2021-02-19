package com.joon.springjpa.post;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;

public class PostRepositoryTestConfig {
    @Bean
    public PostListener postListener(){
        return new PostListener();
    }

    //PostListener 생성 하지 않고 만드는 방법
    @Bean
    public ApplicationListener<PostPublishedEvent> postPublishedEventApplicationListener(){
        return event -> {
                System.out.println("=================================");
                System.out.println(event.getPost()+" is published");
                System.out.println("=================================");
        };
    }
}

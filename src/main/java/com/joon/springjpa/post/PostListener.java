package com.joon.springjpa.post;

import org.springframework.context.ApplicationListener;

public class PostListener implements ApplicationListener<PostPublishedEvent> {
    //implements ApplicationListener<PostPublishedEvent>를 구현하거나
    //@EventListener 사용
    @Override
    public void onApplicationEvent(PostPublishedEvent event) {
        System.out.println("=================================");
        System.out.println(event.getPost()+" is published");
        System.out.println("=================================");

    }
}

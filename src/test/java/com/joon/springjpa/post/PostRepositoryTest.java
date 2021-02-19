package com.joon.springjpa.post;

import com.joon.springjpa.Application;
import org.checkerframework.checker.units.qual.A;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@Import(PostRepositoryTestConfig.class)
public class PostRepositoryTest {
    @Autowired
    PostRepository postRepository;

    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void event(){
        Post post=new Post();
        post.setTitle("event");
        //이벤트를 수동으로 만들어서 보내는 방법
        // PostPublishedEvent postPublishedEvent=new PostPublishedEvent(post);
        // applicationContext.publishEvent(postPublishedEvent);

        //AbstractAggregationRoot<E>를 사용하여 Post 생성 시 보내는 방법
        postRepository.save(post.publish());

    }
    @Test
    public void crud(){
        Post post=new Post();
        post.setTitle("hibernate");
        postRepository.save(post);
        postRepository.delete(post);
        postRepository.flush();

    }
}
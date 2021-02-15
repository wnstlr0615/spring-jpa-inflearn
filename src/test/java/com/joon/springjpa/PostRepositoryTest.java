package com.joon.springjpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class PostRepositoryTest {
    @Autowired
    PostRepository postRepository;

    @Test
   // @Rollback(false) 롤백 취소
    public void crudRepository(){
        //Given
        Post post=new Post();
        post.setTitle("Hello Title");
        //When
        Post newPost = postRepository.save(post);

        //Then
        assertThat(newPost.getId()).isNotNull();

        //When
        List<Post> posts=postRepository.findAll();

        //Then
        assertThat(posts.size()).isEqualTo(1);
        assertThat(posts).contains(newPost);

        //Whem
        Page<Post> postPage = postRepository.findAll(PageRequest.of(0, 10));

        //Then
        assertThat(postPage.getTotalElements()).isEqualTo(1);
        assertThat(postPage.getNumber()).isEqualTo(0);
        assertThat(postPage.getSize()).isEqualTo(10);
        assertThat(postPage.getNumberOfElements()).isEqualTo(1);

        //When
        Page<Post> page = postRepository.findByTitleContains("Hello", PageRequest.of(0, 10));

        //Then
        assertThat(page.getTotalElements()).isEqualTo(1);
        assertThat(page.getNumber()).isEqualTo(0);
        assertThat(page.getSize()).isEqualTo(10);
        assertThat(page.getNumberOfElements()).isEqualTo(1);

    }
}
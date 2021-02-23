package com.joon.springjpa.post;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CommentRepositoryTest {
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    PostRepository postRepository;

    @Test
    public void getComment(){
        Post post = new Post();
        post.setTitle("spring");
        Post savedPost = postRepository.save(post);
        Comment comment=new Comment();
        comment.setComment("comment");
        comment.setPost(savedPost);
        comment.setUp(10);
        comment.setDown(1);
        commentRepository.save(comment);
        commentRepository.findByPost_Id(1l);
    }
    @Test
    public  void getCommentEager(){
        commentRepository.getById(1l);
        System.out.println("========================");
        commentRepository.findById(1l);
    }

}
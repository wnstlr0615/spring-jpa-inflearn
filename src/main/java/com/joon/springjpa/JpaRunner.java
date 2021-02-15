package com.joon.springjpa;

import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.HashSet;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public void run(ApplicationArguments args) throws Exception {
      /* Post post=new Post();
       post.setTitle("Spring Data JPA ");

        Comment comment=new Comment();
        comment.setComment("hello");
        Comment comment1=new Comment();
        comment1.setComment("hello1");
        post.addComment(comment);
        post.addComment(comment1);*/

        Session session = entityManager.unwrap(Session.class);
        //session.save(post);
       // session.save(comment);
       // session.save(comment1);
        Post post = session.get(Post.class, 1L);
        session.delete(post);

    }
}

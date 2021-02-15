package com.joon.springjpa;

import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Post post=new Post();
        post.setTitle("안녕하세요");

        Comment comment=new Comment();
        comment.setComment("hello");
        post.addComment(comment);

        entityManager.persist(post);

        /* TypeSafe 하지 않음

        TypedQuery<Post> query = entityManager.createQuery("select p from Post as p", Post.class);
        List<Post> posts = query.getResultList();
        posts.forEach(System.out::println);
        */

        //TypeSafe한 방법
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Post> query = builder.createQuery(Post.class);
        Root<Post> root = query.from(Post.class);
        query.select(root);
        List<Post> posts = entityManager.createQuery(query).getResultList();
        posts.forEach(System.out::println);



    }
}

package com.joon.springjpa;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository //기존에 하던 방법
public class PostClassRepository {
    @PersistenceContext
    EntityManager entityManager;
    public Post add(Post post){
        entityManager.persist(post);
        return post;
    }
    public void delete(Post post){
        entityManager.remove(post);
    }
    public List<Post> findAll(){
        TypedQuery<Post> query = entityManager.createQuery("SELECT P FROM Post as P", Post.class);
        List<Post> posts = query.getResultList();
        return posts;
    }
}

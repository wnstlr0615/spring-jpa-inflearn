package com.joon.springjpa.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
@Repository
@Transactional
public class PostCustomRepositoryImpl  implements PostCustomRepository<Post>{
    @Autowired
    EntityManager manager;

    @Override
    public List<Post> findMyPost() {
        System.out.println("custom findMyPost");
        return  manager.createQuery("SELECT  p from Post as p ", Post.class).getResultList();
    }

    @Override
    public void delete(Post post) {
        System.out.println("custom delete");
        manager.remove(post);
    }
}

package com.joon.springjpa.post;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long>, PostCustomRepository<Post> {
       // List<Post> findByTitle(String title);
    @Query(value="select * from Post as p where p.title=?1", nativeQuery=true)
    List<Post> findByTitle(String title);

    List<Post> findAll(Sort sort);
}

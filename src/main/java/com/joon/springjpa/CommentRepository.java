package com.joon.springjpa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.List;
import java.util.Optional;

@RepositoryDefinition(domainClass = Comment.class, idClass=Long.class)
public interface CommentRepository {

    Comment save(@NonNull Comment comment);

    List<Comment> findAll();

    @Query("select c from Comment as c")
    List<Comment> findByCommentContains1(String title);

    @Query(value="SELECT * FROM COMMENT", nativeQuery=true)
    List<Comment> findByCommentContains2(String title);



    long count();

    @Nullable
    Optional<Comment> findById(Long id);


}

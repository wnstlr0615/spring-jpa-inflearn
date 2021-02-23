package com.joon.springjpa.post;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository  extends JpaRepository<Comment, Long> {
    //@EntityGraph(value="Comment.post")
    @EntityGraph(attributePaths="post", type= EntityGraph.EntityGraphType.FETCH)
    Optional<Comment> getById(Long id);
    List<CommentSummary> findByPost_Id(Long id); // Close 방식
}

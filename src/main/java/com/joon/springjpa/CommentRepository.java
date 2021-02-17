package com.joon.springjpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.List;
import java.util.Optional;

@RepositoryDefinition(domainClass = Comment.class, idClass=Long.class)
public interface CommentRepository {
    List<Comment> findByCommentContainsIgnoreCase(String keyword); //대소문자 구별하지 않음
    List<Comment> findByCommentContainsIgnoreCaseAndLikeCountGreaterThan(String keyword, int likeCount ); //대소문자 구별x, likeCount 보다 큰 Comment
    List<Comment> findByCommentContainsIgnoreCaseOrderByLikeCountDesc(String keyword); //대소문자 구별 x, likeCount 내림차순
    Page<Comment> findByCommentContainsIgnoreCaseAndLikeCountGreaterThanEqual(String keyword, int like, Pageable pageable);// 페이징 처리
    Comment save(Comment comment);
}

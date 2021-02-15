package com.joon.springjpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

// 진보된 방법
public interface PostRepository extends JpaRepository<Post, Long> {
    Page<Post> findByTitleContains(String title, Pageable pageable);
}

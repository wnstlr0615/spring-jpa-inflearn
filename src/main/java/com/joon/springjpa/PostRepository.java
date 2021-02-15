package com.joon.springjpa;

import org.springframework.data.jpa.repository.JpaRepository;
// 진보된 방법
public interface PostRepository extends JpaRepository<Post, Long> {
}

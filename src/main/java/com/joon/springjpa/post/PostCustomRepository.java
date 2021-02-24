package com.joon.springjpa.post;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PostCustomRepository<T> {
    List<Post> findMyPost();
    void delete(T t);
}

package com.joon.springjpa.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class PostController {
    @Autowired
    PostRepository postRepository;

    @GetMapping("/posts/{id}")
    public String getPost(@PathVariable Long  id){
        Optional<Post> byId = postRepository.findById(id);
        Post post=byId.get();
        return post.getTitle();
    }
    @GetMapping("/posts1/{id}")
    public String getPost1(@PathVariable("id") Post  post){
        return post.getTitle();
    }

    @GetMapping("/posts")
    public PagedModel<EntityModel<Post>> getPosts(Pageable pageable, PagedResourcesAssembler<Post> assembler){
        return assembler.toModel(postRepository.findAll(pageable));
    }

}

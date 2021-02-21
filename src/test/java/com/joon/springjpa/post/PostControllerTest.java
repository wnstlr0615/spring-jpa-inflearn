package com.joon.springjpa.post;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class PostControllerTest {
    @Autowired
    MockMvc mvc;
    @Autowired
    PostRepository postRepository;

    @Test
    public void getPost() throws Exception {
        Post post = createPost("jpa");

        mvc.perform(get("/posts/"+post.getId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("jpa"));
    }

    private Post createPost(String title) {
        Post post = new Post();
        post.setTitle(title);
        postRepository.save(post);
        return post;
    }

    @Test
    public void getPost1() throws Exception {
        Post post1 = createPost("jpa");
        Post post2 = createPost("hello");
        Post post3 = createPost("hi");
        mvc.perform(get("/posts/")
                .param("page", "0")
                .param("size", "10")
                .param("sort", "created,desc")
                .param("sort", "title")
        )
                .andDo(print())
                .andExpect(status().isOk())
                //.andExpect((ResultMatcher) jsonPath("$.content[0].title", "jpa"))
            ;//TODO jsonPath  테스트 오류
    }
    @Test
    public void getPosts(){

    }

}
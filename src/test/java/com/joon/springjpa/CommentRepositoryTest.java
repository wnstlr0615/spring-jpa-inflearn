package com.joon.springjpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CommentRepositoryTest {
    @Autowired
    CommentRepository commentRepository;

    @Test
    public void crud() throws IllegalAccessException, ExecutionException, InterruptedException {
        createComment(2);
        createComment(50);
        createComment(30);



        // 비동기 Future 사용
        Future<List<Comment>> future=
                commentRepository.findByCommentContainsIgnoreCase("Spring");
        System.out.println("=====================================");
        System.out.println("is done?" + future.isDone());
        assertThat(future.get().size()).isEqualTo(3);

        // 비동기 ListenableFuture 사용

        ListenableFuture<List<Comment>> listenableFuture = commentRepository.findByCommentContainsIgnoreCase("Spring");
        listenableFuture.addCallback(new ListenableFutureCallback<List<Comment>>() {
            @Override
            public void onFailure(Throwable ex) {  //실패할 경우
                System.out.println(ex);
            }

            @Override
            public void onSuccess(List<Comment> result) {  // 성공 할 경우
                System.out.println("===============");
                result.forEach(System.out::println);
            }
        });

        List<Comment> comments1 = commentRepository.findByCommentContainsIgnoreCaseAndLikeCountGreaterThan("spring", 1);
        assertThat(comments1.size()).isEqualTo(3);
        List<Comment> comments3 = commentRepository.findByCommentContainsIgnoreCaseOrderByLikeCountDesc("spring");
        assertThat(comments3.get(0).getLikeCount()).isEqualTo(50);

        Page<Comment> commentPage = commentRepository.findByCommentContainsIgnoreCaseAndLikeCountGreaterThanEqual("Spring", 3,  PageRequest.of(0,10, Sort.by(Sort.Direction.DESC, "LikeCount")));
        assertThat(commentPage.getTotalElements()).isEqualTo(2);
        assertThat(commentPage.getTotalPages()).isEqualTo(1);
        assertThat(commentPage.get().collect(Collectors.toList()).get(0).getLikeCount()).isEqualTo(50);
        assertThat(commentPage.get().collect(Collectors.toList()).get(1).getLikeCount()).isEqualTo(30);

    }



    private void createComment(int likeCount) {
        Comment comment=new Comment();
        comment.setLikeCount(likeCount);
        comment.setComment("Hello spring Comment");
        commentRepository.save(comment);
    }
}
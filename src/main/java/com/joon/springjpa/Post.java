package com.joon.springjpa;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "comments")
public class Post {
    @Id@GeneratedValue
    private Long id;

    private String title;
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL )
    private Set<Comment> comments=new HashSet<>();

    public void addComment(Comment comment){
        this.getComments().add(comment);
        comment.setPost(this);
    }
}

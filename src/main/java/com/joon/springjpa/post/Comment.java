package com.joon.springjpa.post;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NamedEntityGraph(name="Comment.post",
        attributeNodes = @NamedAttributeNode("post"))
public class Comment {
    @Id
    @GeneratedValue
    private Long id;

    private String comment;

    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;

}
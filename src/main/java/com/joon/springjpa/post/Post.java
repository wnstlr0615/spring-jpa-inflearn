package com.joon.springjpa.post;

import lombok.*;
import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
//@NamedQuery(name = "Post.finBytTitle", query = "SELECT  p from Post as p where p.title=?1")
public class Post extends AbstractAggregateRoot<Post> {
    @Id
    @GeneratedValue
    private Long id;

    private String title;
    @Lob
    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    public Post publish() {
        registerEvent(new PostPublishedEvent(this));
        return this;
    }
}

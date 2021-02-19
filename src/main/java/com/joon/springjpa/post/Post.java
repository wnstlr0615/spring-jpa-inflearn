package com.joon.springjpa.post;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue
    private Long id;

    private String title;
    @Lob
    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
}

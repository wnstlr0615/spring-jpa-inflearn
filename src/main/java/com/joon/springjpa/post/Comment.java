package com.joon.springjpa.post;

import com.joon.springjpa.Account.Account;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NamedEntityGraph(name="Comment.post",
        attributeNodes = @NamedAttributeNode("post"))
@EntityListeners(AuditingEntityListener.class)
public class Comment {
    @Id
    @GeneratedValue
    private Long id;

    private String comment;

    private int up;

    private int down;

    private boolean best;

    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;

    @CreatedDate
    private Date created;

    @CreatedBy
    @ManyToOne
    private Account createdBy;
    @LastModifiedDate
    private Date updated;

    @LastModifiedBy
    @ManyToOne
    private Account updatedBy;

    @PrePersist
    public void prePersist(){
        System.out.println("pre Persist is called");
    }

}

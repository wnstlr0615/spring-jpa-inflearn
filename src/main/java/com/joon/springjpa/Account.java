package com.joon.springjpa;

import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.util.Date;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "users")
public class Account {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String password;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Transient
    private String no;

}

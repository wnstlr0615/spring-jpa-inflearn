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

    @Embedded
    @AttributeOverrides(
           value = { @AttributeOverride(name = "street", column = @Column(name = "home_street")),
                   @AttributeOverride(name="city", column = @Column(name = "home_city")),
                   @AttributeOverride(name="state", column = @Column(name = "home_state")),
                   @AttributeOverride(name="zipCode", column = @Column(name = "home_zip_code"))}
    )
    private Address  homeAddress;

    @Embedded
    private Address officeAddress;

}

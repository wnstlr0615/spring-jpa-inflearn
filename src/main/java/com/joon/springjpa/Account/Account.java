package com.joon.springjpa.Account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id@GeneratedValue
    private Long id;

    private String username;

    private String firstName;

    private String lastName;




}

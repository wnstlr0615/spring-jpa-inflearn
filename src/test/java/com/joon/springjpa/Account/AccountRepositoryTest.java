package com.joon.springjpa.Account;

import com.querydsl.core.types.Predicate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryTest {
    @Autowired
    AccountRepository accountRepository;
    @Test
    public void crud(){
        QAccount account = QAccount.account;
        Predicate predicate= account
                .firstName.containsIgnoreCase("joon")
                .and(account.lastName.startsWith("choi"));

        Optional<Account> one = accountRepository.findOne(predicate);
        assertThat(one).isEmpty();
    }
}
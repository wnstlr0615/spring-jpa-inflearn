package com.joon.springjpa;

import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.HashSet;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Account account=Account.builder()
                            .username("joon123")
                            .password("1234")
                            .created(new Date())
                            .studies(new HashSet<>())
                            .build();
        Study study=Study.builder()
                        .name("Spring Data JPA")
                        .build();
        account.addStudy(study);

        Session session = entityManager.unwrap(Session.class);

        session.save(account);
        session.save(study);

    }
}

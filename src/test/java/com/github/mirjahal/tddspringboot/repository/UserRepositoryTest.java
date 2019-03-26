package com.github.mirjahal.tddspringboot.repository;

import com.github.mirjahal.tddspringboot.databuilder.UserDataBuilder;
import com.github.mirjahal.tddspringboot.model.User;
import java.util.Optional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void givenValidUserIdWhenFindUserByIdInDatabseThenReturnUser() {
        User savedUser = testEntityManager.persistFlushFind(new UserDataBuilder().withId(123).withName("José").build());

        User userById = userRepository.findById(123).get();

        assertEquals(savedUser, userById);
    }

}
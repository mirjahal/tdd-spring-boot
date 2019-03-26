package com.github.mirjahal.tddspringboot.business;

import com.github.mirjahal.tddspringboot.business.UserBusiness;
import com.github.mirjahal.tddspringboot.databuilder.UserDataBuilder;
import com.github.mirjahal.tddspringboot.model.User;
import com.github.mirjahal.tddspringboot.repository.UserRepository;
import java.util.Optional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserBusinessTest {

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserBusiness userBusiness;

    @Test
    public void givenValidUserIdWhenGetUserByIdInDatabseThenReturnUser() {
        User user = new UserDataBuilder()
            .withId(75)
            .withName("José")
            .build();

        when(userRepository.findById(anyInt())).thenReturn(Optional.of(user));

        User userById = userBusiness.getUserById(anyInt());

        assertEquals(user, userById);
    }

}
package com.github.mirjahal.tddspringboot;

import com.github.mirjahal.tddspringboot.business.UserBusiness;
import com.github.mirjahal.tddspringboot.databuilder.UserDataBuilder;
import com.github.mirjahal.tddspringboot.model.User;
import com.github.mirjahal.tddspringboot.repository.UserRepository;
import java.util.Optional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@AutoConfigureTestDatabase
public class CachingTest {

    @Autowired
    private UserBusiness userBusiness;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void shouldReturnCachedUserWhenInvokeGetUserById() {
        User user = new UserDataBuilder()
            .withId(75)
            .withName("José")
            .build();

        given(userRepository.findById(anyInt())).willReturn(Optional.of(user));

        userBusiness.getUserById(75);
        userBusiness.getUserById(75);

        verify(userRepository, times(1)).findById(75);
    }

}

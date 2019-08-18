package com.github.mirjahal.tddspringboot;

import static org.junit.Assert.assertEquals;

import com.github.mirjahal.tddspringboot.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void givenValidUserIdWhenGetUserByIdThenReturnUser() {
        ResponseEntity<User> responseEntity = testRestTemplate.getForEntity("/users/{id}", User.class, 123);

        assertEquals(responseEntity.getStatusCode(), HttpStatus.NOT_FOUND);
    }

}

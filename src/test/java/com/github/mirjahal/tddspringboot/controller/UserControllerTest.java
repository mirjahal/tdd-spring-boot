package com.github.mirjahal.tddspringboot.controller;

import com.github.mirjahal.tddspringboot.business.UserBusiness;
import com.github.mirjahal.tddspringboot.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserBusiness userBusiness;

    @Test
    public void givenValidUserIdWhenGetUserByIdThenReturnUser() throws Exception {
        when(userBusiness.getUserById(anyInt())).thenReturn(new User());

        mockMvc
            .perform(get("/users/{id}", 123))
            .andExpect(status().isOk());
    }

}

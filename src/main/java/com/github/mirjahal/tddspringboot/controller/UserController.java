package com.github.mirjahal.tddspringboot.controller;

import com.github.mirjahal.tddspringboot.business.UserBusiness;
import com.github.mirjahal.tddspringboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserBusiness userBusiness;

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") int id) {
        return userBusiness.getUserById(id);
    }

}

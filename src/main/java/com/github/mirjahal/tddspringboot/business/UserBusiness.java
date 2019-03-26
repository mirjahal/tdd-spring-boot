package com.github.mirjahal.tddspringboot.business;

import com.github.mirjahal.tddspringboot.model.User;
import com.github.mirjahal.tddspringboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserBusiness {

    @Autowired
    private UserRepository userRepository;

    @Cacheable("users")
    public User getUserById(int id) {
        return userRepository.findById(id).get();
    }

}

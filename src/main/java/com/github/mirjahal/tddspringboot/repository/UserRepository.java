package com.github.mirjahal.tddspringboot.repository;

import com.github.mirjahal.tddspringboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}

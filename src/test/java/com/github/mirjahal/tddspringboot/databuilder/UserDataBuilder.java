package com.github.mirjahal.tddspringboot.databuilder;

import com.github.mirjahal.tddspringboot.model.User;

public class UserDataBuilder {

    private int id;
    private String name;

    public UserDataBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public UserDataBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public User build() {
        User user = new User();
        user.setId(id);
        user.setName(name);

        return user;
    }

}

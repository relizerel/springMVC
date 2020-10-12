package com.spring.service;

import com.spring.model.User;

public interface UserService {
    User getUser(Long id);
    User saveUser(User user);
    User updateUser(User user);
    User deleteUser(User user);
}

package com.spring.dao;

import com.spring.model.User;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public interface UserDao {
    User getUser(Long id);
    User saveUser(User user);
    User updateUser(User user);
    User deleteUser(User user);
    List<User> listAll();
}


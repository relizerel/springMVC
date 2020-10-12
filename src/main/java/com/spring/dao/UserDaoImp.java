package com.spring.dao;

import com.spring.model.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
@Repository
public class UserDaoImp implements UserDao {


    @PersistenceContext
    private EntityManager entityManger;

    @Override
    public User getUser(Long id) {
        return (User) entityManger.find(User.class, id);
    }


    @Override
    public User saveUser(User user) {
        entityManger.persist(user);
        return user;
    }

    @Override
    public User updateUser(User user) {
        entityManger.merge(user);
        return user;
    }

    @Override
    public User deleteUser(User user) {
        if (entityManger.contains(user)) {
            entityManger.remove(user);
        } else {
            entityManger.remove(entityManger.merge(user));
        }

        return user;
    }
}

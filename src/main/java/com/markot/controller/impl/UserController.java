package com.markot.controller.impl;

import com.markot.controller.AbstractGenericController;
import com.markot.model.dao.impl.UserDao;
import com.markot.model.entity.User;

import java.sql.SQLException;
import java.util.List;

public class UserController implements AbstractGenericController<User> {
    private final UserDao userDao = new UserDao();


    @Override
    public List<User> findAll() throws SQLException {
        return (List<User>) userDao.findAll();
    }

    @Override
    public User findOne(Integer id) throws SQLException {
        return userDao.findOne(id);
    }

    @Override
    public void create(User user) throws SQLException {
        userDao.create(user);
    }

    @Override
    public void update(Integer id, User user) throws SQLException {
        if (userDao.findOne(id) == null){
            System.out.println("User does not exist");
        } else {
            userDao.update(id, user);
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        if (userDao.findOne(id) == null){
            System.out.println("User does not exist");
        } else {
            userDao.delete(id);
        }
    }
}

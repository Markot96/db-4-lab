package com.markot.controller.impl;

import com.markot.controller.AbstractGenericController;
import com.markot.model.dao.impl.PasswordDao;
import com.markot.model.entity.Password;

import java.sql.SQLException;
import java.util.List;

public class PasswordController implements AbstractGenericController<Password> {
    private final PasswordDao passwordDao = new PasswordDao();

    @Override
    public List<Password> findAll() throws SQLException {
        return (List<Password>) passwordDao.findAll();
    }

    @Override
    public Password findOne(Integer id) throws SQLException {
        return passwordDao.findOne(id);
    }

    @Override
    public void create(Password password) throws SQLException {
        passwordDao.create(password);
    }

    @Override
    public void update(Integer id, Password password) throws SQLException {
        if (passwordDao.findOne(id) == null){
            System.out.println("Password does not exist");
        } else {
            passwordDao.update(id, password);
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        if (passwordDao.findOne(id) == null){
            System.out.println("Password does not exist");
        } else {
            passwordDao.delete(id);
        }
    }
}

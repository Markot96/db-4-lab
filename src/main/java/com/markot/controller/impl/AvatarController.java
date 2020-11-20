package com.markot.controller.impl;

import com.markot.controller.AbstractGenericController;
import com.markot.model.dao.impl.AvatarDao;
import com.markot.model.entity.Avatar;

import java.sql.SQLException;
import java.util.List;

public class AvatarController implements AbstractGenericController<Avatar> {
    private final AvatarDao avatarDao = new AvatarDao();


    @Override
    public List<Avatar> findAll() throws SQLException {
        return avatarDao.findAll();
    }

    @Override
    public Avatar findOne(Integer id) throws SQLException {
        return avatarDao.findOne(id);
    }

    @Override
    public void create(Avatar adress) throws SQLException {
        avatarDao.create(adress);
    }

    @Override
    public void update(Integer id, Avatar adress) throws SQLException {
        if (avatarDao.findOne(id) == null){
            System.out.println("Avatar does not exist");
        } else {
            avatarDao.update(id, adress);
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        if (avatarDao.findOne(id) == null){
            System.out.println("Avatar does not exist");
        } else {
            avatarDao.delete(id);
        }
    }
}
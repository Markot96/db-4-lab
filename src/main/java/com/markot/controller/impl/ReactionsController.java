package com.markot.controller.impl;

import com.markot.controller.AbstractGenericController;
import com.markot.model.dao.impl.ReactionsDao;
import com.markot.model.entity.Reactions;

import java.sql.SQLException;
import java.util.List;

public class ReactionsController implements AbstractGenericController<Reactions> {
    private final ReactionsDao reactionsDao = new ReactionsDao();

    @Override
    public List<Reactions> findAll() throws SQLException {
        return (List<Reactions>) reactionsDao.findAll();
    }

    @Override
    public Reactions findOne(Integer id) throws SQLException {
        return reactionsDao.findOne(id);
    }

    @Override
    public void create(Reactions reactions) throws SQLException {
        reactionsDao.create(reactions);
    }

    @Override
    public void update(Integer id, Reactions reactions) throws SQLException {
        if (reactionsDao.findOne(id) == null){
            System.out.println("Reactions does not exist");
        } else {
            reactionsDao.update(id, reactions);
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        if (reactionsDao.findOne(id) == null){
            System.out.println("Reactions does not exist");
        } else {
            reactionsDao.delete(id);
        }
    }
}

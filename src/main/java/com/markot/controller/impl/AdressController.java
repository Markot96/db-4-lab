package com.markot.controller.impl;

import com.markot.controller.AbstractGenericController;
import com.markot.model.dao.impl.AdressDao;
import com.markot.model.entity.Adress;

import java.sql.SQLException;
import java.util.List;

public class AdressController implements AbstractGenericController<Adress> {
    private final AdressDao adressDao = new AdressDao();


    @Override
    public List<Adress> findAll() throws SQLException {
        return adressDao.findAll();
    }

    @Override
    public Adress findOne(Integer id) throws SQLException {
        return adressDao.findOne(id);
    }

    @Override
    public void create(Adress adress) throws SQLException {
        adressDao.create(adress);
    }

    @Override
    public void update(Integer id, Adress adress) throws SQLException {
        if (adressDao.findOne(id) == null){
            System.out.println("Adress does not exist");
        } else {
            adressDao.update(id, adress);
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        if (adressDao.findOne(id) == null){
            System.out.println("Adress does not exist");
        } else {
            adressDao.delete(id);
        }
    }
}
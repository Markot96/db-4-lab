package com.markot.controller.impl;

import com.markot.controller.AbstractGenericController;
import com.markot.model.dao.impl.StoryLineDao;
import com.markot.model.entity.StoryLine;

import java.sql.SQLException;
import java.util.List;

public class StoryLineController implements AbstractGenericController<StoryLine> {
    private final StoryLineDao storyLineDao = new StoryLineDao();


    @Override
    public List<StoryLine> findAll() throws SQLException {
        return (List<StoryLine>) storyLineDao.findAll();
    }

    @Override
    public StoryLine findOne(Integer userId) throws SQLException {
        return storyLineDao.findOne(userId);
    }

    @Override
    public void create(StoryLine storyLine) throws SQLException {
        storyLineDao.create(storyLine);
    }

    @Override
    public void update(Integer userId, StoryLine storyLine) throws SQLException {
        if (storyLineDao.findOne(userId) == null){
            System.out.println("StoryLine does not exist");
        } else {
            storyLineDao.update(userId, storyLine);
        }
    }

    @Override
    public void delete(Integer userId) throws SQLException {
        if (storyLineDao.findOne(userId) == null){
            System.out.println("StoryLine does not exist");
        } else {
            storyLineDao.delete(userId);
        }
    }
}
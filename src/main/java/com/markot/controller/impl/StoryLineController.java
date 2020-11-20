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
        return storyLineDao.findAll();
    }

    @Override
    public StoryLine findOne(Integer user_id) throws SQLException {
        return storyLineDao.findOne(user_id);
    }

    @Override
    public void create(StoryLine storyLine) throws SQLException {
        storyLineDao.create(storyLine);
    }

    @Override
    public void update(Integer user_id, StoryLine storyLine) throws SQLException {
        if (storyLineDao.findOne(user_id) == null){
            System.out.println("StoryLine does not exist");
        } else {
            storyLineDao.update(user_id, storyLine);
        }
    }

    @Override
    public void delete(Integer user_id) throws SQLException {
        if (storyLineDao.findOne(user_id) == null){
            System.out.println("StoryLine does not exist");
        } else {
            storyLineDao.delete(user_id);
        }
    }
}
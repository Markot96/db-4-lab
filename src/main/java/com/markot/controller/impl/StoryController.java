package com.markot.controller.impl;

import com.markot.controller.AbstractGenericController;
import com.markot.model.dao.impl.StoryDao;
import com.markot.model.entity.Story;

import java.sql.SQLException;
import java.util.List;

public class StoryController implements AbstractGenericController<Story> {
    private final StoryDao storyDao = new StoryDao();


    @Override
    public List<Story> findAll() throws SQLException {
        return storyDao.findAll();
    }

    @Override
    public Story findOne(Integer id) throws SQLException {
        return storyDao.findOne(id);
    }

    @Override
    public void create(Story story) throws SQLException {
        storyDao.create(story);
    }

    @Override
    public void update(Integer id, Story story) throws SQLException {
        if (storyDao.findOne(id) == null){
            System.out.println("Story does not exist");
        } else {
            storyDao.update(id, story);
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        if (storyDao.findOne(id) == null){
            System.out.println("Story does not exist");
        } else {
            storyDao.delete(id);
        }
    }
}

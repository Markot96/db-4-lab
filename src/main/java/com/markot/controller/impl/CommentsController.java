package com.markot.controller.impl;

import com.markot.controller.AbstractGenericController;
import com.markot.model.dao.impl.CommentsDao;
import com.markot.model.entity.Comments;

import java.sql.SQLException;
import java.util.List;

public class CommentsController implements AbstractGenericController<Comments> {
    private final CommentsDao commentsDao = new CommentsDao();


    @Override
    public List<Comments> findAll() throws SQLException {
        return commentsDao.findAll();
    }

    @Override
    public Comments findOne(Integer id) throws SQLException {
        return commentsDao.findOne(id);
    }

    @Override
    public void create(Comments comment) throws SQLException {
        commentsDao.create(comment);
    }

    @Override
    public void update(Integer id, Comments comment) throws SQLException {
        if (commentsDao.findOne(id) == null){
            System.out.println("Comment does not exist");
        } else {
            commentsDao.update(id, comment);
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        if (commentsDao.findOne(id) == null){
            System.out.println("Comment does not exist");
        } else {
            commentsDao.delete(id);
        }
    }
}
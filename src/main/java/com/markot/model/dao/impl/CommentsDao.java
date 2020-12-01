package com.markot.model.dao.impl;

import com.markot.model.dao.AbstractGenericDao;
import com.markot.model.entity.Comments;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.markot.util.HibernateUtil;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CommentsDao implements AbstractGenericDao<Comments> {
    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public Collection<Comments> findAll() {
        List<Comments> comments = new ArrayList<>();

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            comments = session.createQuery("from Comments ").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return comments;
    }

    @Override
    public Comments findOne(Integer id) throws SQLException {
        Comments comment = null;

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            comment = session.get(Comments.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return comment;
    }

    @Override
    public void create(Comments comment) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(comment);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Comments comment) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(comment);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void delete(Integer id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Comments comment = session.get(Comments.class, id);
            if (comment != null) {
                session.delete(comment);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
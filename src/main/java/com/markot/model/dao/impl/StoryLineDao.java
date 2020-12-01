package com.markot.model.dao.impl;

import com.markot.model.dao.AbstractGenericDao;
import com.markot.model.entity.StoryLine;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.markot.util.HibernateUtil;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StoryLineDao implements AbstractGenericDao<StoryLine> {
    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public Collection<StoryLine> findAll() {
        List<StoryLine> storyLine = new ArrayList<>();

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            storyLine = session.createQuery("from StoryLine ").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return storyLine;
    }

    @Override
    public StoryLine findOne(Integer userId) throws SQLException {
        StoryLine storyLine = null;

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            storyLine = session.get(StoryLine.class, userId);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return storyLine;
    }

    @Override
    public void create(StoryLine storyLine) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(storyLine);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer userId, StoryLine storyLine) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(storyLine);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void delete(Integer userId) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            StoryLine storyLine = session.get(StoryLine.class, userId);
            if (storyLine != null) {
                session.delete(storyLine);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
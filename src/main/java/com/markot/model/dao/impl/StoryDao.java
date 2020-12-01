package com.markot.model.dao.impl;

import com.markot.model.dao.AbstractGenericDao;
import com.markot.model.entity.Story;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.markot.util.HibernateUtil;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StoryDao implements AbstractGenericDao<Story> {
    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public Collection<Story> findAll() {
        List<Story> story = new ArrayList<>();

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            story = session.createQuery("from Story ").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return story;
    }

    @Override
    public Story findOne(Integer id) throws SQLException {
        Story story = null;

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            story = session.get(Story.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return story;
    }

    @Override
    public void create(Story story) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(story);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Story story) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(story);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void delete(Integer id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Story story = session.get(Story.class, id);
            if (story != null) {
                session.delete(story);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
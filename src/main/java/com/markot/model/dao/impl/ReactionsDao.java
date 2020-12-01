package com.markot.model.dao.impl;

import com.markot.model.dao.AbstractGenericDao;
import com.markot.model.entity.Reactions;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.markot.util.HibernateUtil;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ReactionsDao implements AbstractGenericDao<Reactions> {
    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public Collection<Reactions> findAll() {
        List<Reactions> reactions = new ArrayList<>();

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            reactions = session.createQuery("from Reactions ").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reactions;
    }

    @Override
    public Reactions findOne(Integer id) throws SQLException {
        Reactions reaction = null;

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            reaction = session.get(Reactions.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reaction;
    }

    @Override
    public void create(Reactions reaction) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(reaction);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Reactions reaction) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(reaction);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void delete(Integer id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Reactions reaction = session.get(Reactions.class, id);
            if (reaction != null) {
                session.delete(reaction);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
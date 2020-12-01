package com.markot.model.dao.impl;

import com.markot.model.dao.AbstractGenericDao;
import com.markot.model.entity.Password;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.markot.util.HibernateUtil;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PasswordDao implements AbstractGenericDao<Password> {
    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public Collection<Password> findAll() {
        List<Password> passwords = new ArrayList<>();

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            passwords = session.createQuery("from Password ").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return passwords;
    }

    @Override
    public Password findOne(Integer id) throws SQLException {
        Password password = null;

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            password = session.get(Password.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return password;
    }

    @Override
    public void create(Password password) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(password);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Password password) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(password);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void delete(Integer id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Password password = session.get(Password.class, id);
            if (password != null) {
                session.delete(password);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
package com.company.yatsenko.dao.impl;

import com.company.yatsenko.dao.UserDao;
import com.company.yatsenko.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HibernateUserDao implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session currentSession() {
        return sessionFactory.openSession();
    }

    @Override
    public void addUser(User user) {
        currentSession().save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return currentSession().createQuery("from com.company.yatsenko.model.User", User.class).list();
    }

    @Override
    public User getUserByEmail(String email) {
        Query<User> query=currentSession().createQuery("from User where email=:email",User.class);
        query.setParameter("email",email);
        return query.list().stream().findAny().orElse(null);
    }
}

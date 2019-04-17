package com.company.yatsenko.dao.impl;

import com.company.yatsenko.dao.UserDao;
import com.company.yatsenko.model.User;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
@Transactional(readOnly = true)
//@EnableTransactionManagement//<tx:annotation-driven/>
public class JpaUserDao implements UserDao {
    @PersistenceContext(unitName = "entityManagerFactory")//Component depends on entity manager and his persistence-context
    private EntityManager entityManager;


    @Override
    @Transactional
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public User getUserByEmail(String email) {
        TypedQuery<User> q = entityManager.createQuery("select u from User u where u.email=:email", User.class);
        q.setParameter("email", email);
        return q.getResultList().stream().findAny().orElse(null);
    }
}

package com.company.yatsenko.dao.impl;

import com.company.yatsenko.dao.UserDao;
import com.company.yatsenko.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcTemplateUserDao implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<User> getAllUsers() {//rowMapper using for parsing objects for ResultSett<>();
        return jdbcTemplate.query("select *from users", new BeanPropertyRowMapper<>(User.class));
    }

    public User getUserByEmail(String email) {
        return jdbcTemplate.query("select *from users where email=?", new Object[]{email}, new BeanPropertyRowMapper<>(User.class))
                .stream()
                .findAny()
                .orElse(null);
    }

    public void addUser(User user) {
        jdbcTemplate.update("INSERT INTO users VALUES (?,?,?)", user.getName(), user.getSurname(), user.getEmail());
    }
}

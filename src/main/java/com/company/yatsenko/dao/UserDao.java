package com.company.yatsenko.dao;

import com.company.yatsenko.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

public interface UserDao {
    public abstract void addUser(User user);

    public abstract List<User> getAllUsers();

    public abstract User getUserByEmail(String email);
}

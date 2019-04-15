package com.company.yatsenko.services;

import com.company.yatsenko.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {
    public void addUser(User user);
    public List<User> getAllUsers();
    public User getUserByEmail(String email);
}

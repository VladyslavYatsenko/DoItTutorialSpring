package com.company.yatsenko.util;

import com.company.yatsenko.dao.UserDao;
import com.company.yatsenko.model.User;
import com.company.yatsenko.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        if (userService.getUserByEmail(user.getEmail())!=null){
            errors.rejectValue("email","","This is email is already in use");
        }
    }
}
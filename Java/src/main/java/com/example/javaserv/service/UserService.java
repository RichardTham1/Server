package com.example.javaserv.service;

import com.example.javaserv.User;
import com.example.javaserv.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserManager userManager;

    @Autowired
    public UserService(UserManager userManager) {
        this.userManager = userManager;
    }

    public void createUser(User user) {
        userManager.addUser(user);
    }

    public User getUser(String email) {
        return userManager.getUser(email);
    }

    public void updateActivityOfUser(User user) {
        userManager.updateActivity(user.getEmail());
    }
}

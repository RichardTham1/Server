package com.example.javaserv.service;

import com.example.javaserv.Course;
import com.example.javaserv.SessionManager;
import com.example.javaserv.User;
import com.example.javaserv.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class UserService {
    private final SessionManager sessionManager;
    private final FirestoreService firestoreService;

    @Autowired
    public UserService(SessionManager sessionManager, FirestoreService firestoreService) {
        this.sessionManager = sessionManager;
        this.firestoreService = firestoreService;
    }

    public void createUser(User user) {
        sessionManager.addUser(user);
        firestoreService.addUser(user);
    }

    public User getUser(String email) throws ExecutionException, InterruptedException {
        return sessionManager.getUser(email);
    }

    public void addCourseToUser(String email, Course course) throws ExecutionException, InterruptedException {
        User user = sessionManager.getUser(email);
        user.addCourse(course);
    }


}

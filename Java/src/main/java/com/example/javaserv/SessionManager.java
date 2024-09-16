package com.example.javaserv;

import com.example.javaserv.service.FirestoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

@Component
public class SessionManager {

    private final UserManager userManager;
    private final FirestoreService firestoreService;
    @Autowired
    public SessionManager(UserManager userManager, FirestoreService firestoreService) {
        this.userManager = userManager;
        this.firestoreService = firestoreService;
    }

    public User getUser(String email) throws ExecutionException, InterruptedException {
        User user = this.userManager.getUser(email);
        if (user == null) {
            user = firestoreService.getUser(email);
            this.userManager.addUser(user);
        }
        this.updateActivityOfUser(user);
        return user;
    }

    public void addUser(User user) {
        this.userManager.addUser(user);
    }

    @Scheduled(fixedRate = 300000)
    private void updateDbForRemovedUser() {
        ArrayList<User> removedUser = this.userManager.cleanUpInactiveUsers();
        for (User user: removedUser) {
            firestoreService.addUser(user);
        }
    }

    public void updateActivityOfUser(User user) {
        userManager.updateActivity(user.getEmail());
    }
}

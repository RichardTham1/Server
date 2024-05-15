package com.example.javaserv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserManager {
    private final HashMap<String, User> userMap = new HashMap<>();

    public void addUser(User user) {
        userMap.put(user.getEmail(), user);
    }

    public User getUser(String email) {
        return userMap.get(email);
    }

    public void updateActivity(String email) {
        User user = userMap.get(email);
        if (user != null) {
            user.setLastActivity(System.currentTimeMillis());
        }
    }

    @Scheduled(fixedDelay = Constants.THIRTY_MINUTES_IN_MILLIS)
    public void cleanUpInactiveUsers() {
        long currentTime = System.currentTimeMillis();
        long inactivityThreshold = Constants.THIRTY_MINUTES_IN_MILLIS;
        for (Map.Entry<String, User> entry: userMap.entrySet()) {
            User user = entry.getValue();
            if (currentTime - user.getLastActivity() >= inactivityThreshold) {
                String key = entry.getKey();
                userMap.remove(key);
            }
        }
    }
}

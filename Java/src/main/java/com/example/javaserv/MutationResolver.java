package com.example.javaserv;

import com.example.javaserv.service.FirestoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class MutationResolver {
    @Autowired
    private FirestoreService firestoreService;
    @MutationMapping
    public User createUser(@Argument String email) {
        User newUser = new User(email);
        firestoreService.addUser(newUser);
        return newUser;
    }

    /*@MutationMapping
    public User addCourse(@Argument String email, @Argument String courseName) {
        User user = User.getUser(email);
        user.addCourse(courseName);
        return user;
    }*/
}

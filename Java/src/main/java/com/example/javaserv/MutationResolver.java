package com.example.javaserv;

import com.example.javaserv.service.FirestoreService;
import com.example.javaserv.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.concurrent.ExecutionException;

@Controller
public class MutationResolver {
    @Autowired
    private UserService userService;

    @MutationMapping
    public User createUser(@Argument String email) {
        User newUser = new User(email);
        userService.createUser(newUser);
        return newUser;
    }

    @MutationMapping
    public User addCourse(@Argument String email, @Argument Course course) throws ExecutionException, InterruptedException {
        userService.addCourseToUser(email, course);
        return userService.getUser(email);
    }
}

package com.example.javaserv;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class MutationResolver {
    @MutationMapping
    public User createUser(@Argument String email) {
        return new User(email);
    }

    @MutationMapping
    public User addCourse(@Argument String email, @Argument String courseName) {
        User user = User.getUser(email);
        user.addCourse(courseName);
        return user;
    }
}

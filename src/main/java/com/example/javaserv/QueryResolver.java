package com.example.javaserv;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;

@Controller
public class QueryResolver {
    @QueryMapping
    public User getUser(@Argument String email) {
        return User.getUser(email);
    }

    @QueryMapping
    public List<Course> courses(User user) {
        return user.getCourses();
    }

}

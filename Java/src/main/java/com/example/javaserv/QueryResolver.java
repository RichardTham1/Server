package com.example.javaserv;

import com.example.javaserv.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Controller
public class QueryResolver {

    @Autowired
    private final UserService userService;

    public QueryResolver(UserService userService) {
        this.userService = userService;
    }

    @QueryMapping
    public User getUser(@Argument String email) throws ExecutionException, InterruptedException {
        return userService.getUser(email);
    }

    @QueryMapping
    public List<Course> courses(@Argument String email) throws ExecutionException, InterruptedException {
        return userService.getUser(email).getCourses();
    }

}

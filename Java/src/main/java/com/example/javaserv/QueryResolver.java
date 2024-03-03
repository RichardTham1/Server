package com.example.javaserv;

import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
public class QueryResolver {
    @SchemaMapping(typeName = "Query")
    public User getUserById(String id) {
        return null;
    }
}

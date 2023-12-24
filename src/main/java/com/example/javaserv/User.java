package com.example.javaserv;


import java.util.HashMap;

public class User {
    private String uid;
    private HashMap<String, Course> courses;
    public User(String uid) { this.uid = uid; }

}

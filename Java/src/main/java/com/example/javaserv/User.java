package com.example.javaserv;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class User {
    private String email;
    private List<Course> courses = new ArrayList<>();
    public User(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void addCourse(String courseName) {
        courses.add(new Course(courseName));
    }

    public List<Course> getCourses() {
        return courses;
    }
}

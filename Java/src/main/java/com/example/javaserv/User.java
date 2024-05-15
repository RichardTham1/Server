package com.example.javaserv;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class User {
    private final String email;
    private long lastActivity;
    private final List<Course> courses = new ArrayList<>();
    public User(String email) {
        this.email = email;
        this.lastActivity = System.currentTimeMillis();
    }

    public String getEmail() {
        return this.email;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public List<Course> getCourses() {
        return courses;
    }

    public long getLastActivity() {
        return lastActivity;
    }

    public void setLastActivity(long lastActivity) {
        this.lastActivity = lastActivity;
    }
}

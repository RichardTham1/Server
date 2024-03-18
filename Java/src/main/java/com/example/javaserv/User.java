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
        userList.add(this);
    }
    private static List<User> userList = new ArrayList<>();

    public static User getUser(String email) {
        return userList.stream().filter(user -> Objects.equals(user.email, email)).findFirst().orElse(null);
    }

    public void addCourse(String courseName) {
        courses.add(new Course(courseName));
    }

    public List<Course> getCourses() {
        return courses;
    }
}

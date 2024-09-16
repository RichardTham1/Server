package com.example.javaserv;
import com.google.common.collect.Iterables;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class User {
    private String email;
    private long lastActivity;
    private final ArrayList<Course> courses = new ArrayList<>();

    public User(String email, long lastActivity) {
        this.email = email;
        this.lastActivity = System.currentTimeMillis();
    }

    /*public User(String email, long lastActivity, List<Course> courses) {
        this.email = email;
        this.lastActivity = System.currentTimeMillis();
        this.courses.addAll(courses);
    }*/

    public User(){}

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

    public void modifyCourse(String courseName, Course courseToModify) {
        int index = Iterables.indexOf(courses, course -> course.getCourseName().equals(courseName));
        courses.remove(index);
        courses.add(index, courseToModify);
    }

    public void removeCourse(String courseName) {
        int index = Iterables.indexOf(courses, course -> course.getCourseName().equals(courseName));
        courses.remove(index);
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

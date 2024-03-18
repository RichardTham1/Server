package com.example.javaserv;


import java.util.ArrayList;
import java.util.List;

public class Course {
    private List<Mark> markList = new ArrayList<>();

    private String courseName;
    private Integer passingGrade;
    private Integer grade;
    private Integer accumulatedPoints;
    public Course(String name) {
        courseName = name;
    }

    private void evaluateAccumulatedPoints() {
        accumulatedPoints = 0;
        for (Mark mark: markList) {
            accumulatedPoints += mark.getMark() * mark.getWeight();
        }
    }
    
    private void evaluateGrade() {
        // TODO: 2023-12-23 verify how to calculate grade for without having all the marks entered 
    }

    public Integer getGrade() {
        return grade;
    }
}

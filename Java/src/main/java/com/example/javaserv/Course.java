package com.example.javaserv;


import java.util.ArrayList;
import java.util.List;

public class Course {
    private List<Mark> markList;
    private String courseName;
    private Integer passingGrade;
    private Integer grade = 0;
    private Integer accumulatedPoints = 0;
    public Course(String courseName, Integer passingGrade, ArrayList<Mark> marks) {
        this.courseName = courseName;
        this.passingGrade = passingGrade;
        this.markList = marks;
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

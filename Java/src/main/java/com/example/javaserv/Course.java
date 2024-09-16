package com.example.javaserv;


import com.google.cloud.firestore.DocumentSnapshot;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private ArrayList<Mark> marks;
    private String courseName;
    private Integer passingGrade;
    private Float grade = 0f;
    private Float accumulatedPoints = 0f;
    private Float pointsLeft;

    public Course() {}

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setAccumulatedPoints(Float accumulatedPoints) {
        this.accumulatedPoints = accumulatedPoints;
    }

    public void setGrade(Float grade) {
        this.grade = grade;
    }

    public void setMarks(ArrayList<Mark> marks) {
        this.marks = marks;
    }

    public void setPassingGrade(Integer passingGrade) {
        if (passingGrade > 100) {
            this.passingGrade = 100;
        } else {
            this.passingGrade = passingGrade;
        }
    }

    public void evaluate() {
        accumulatedPoints = 0f;
        Float weightSum = 0f;
        for (Mark mark: marks) {
            if (mark.getMark() == null) continue;
            accumulatedPoints += mark.getMark() * mark.getWeight() / 100;
            weightSum += mark.getWeight();
        }
        grade = Math.round((100 * accumulatedPoints / weightSum) * 10) / 10.0f;
        pointsLeft = 100f - weightSum;
    }

    public ArrayList<Mark> getMarks() {
        return marks;
    }

    public Float getGrade() {
        return grade;
    }

    public String getCourseName() {
        return courseName;
    }

    public Integer getPassingGrade() {
        return passingGrade;
    }

    public Float getAccumulatedPoints() {
        return accumulatedPoints;
    }

    public Float getPointsLeft() {
        return pointsLeft;
    }

    public void setPointsLeft(Float pointsLeft) {
        this.pointsLeft = pointsLeft;
    }
}

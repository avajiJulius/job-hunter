package com.jobhunter.employeeform.domain;

public class Education {
    private University university;
    private Course course;

    public Education() {
    }

    public Education(University university, Course course) {
        this.university = university;
        this.course = course;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}

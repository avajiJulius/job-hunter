package com.jobhunter.education.domain;

import java.time.LocalDate;

public class CourseCertificate {
    private Long courseCertificateId;
    private String courseNumber;
    private LocalDate courseIssueDate;
    private Person coursePerson;

    public Long getCourseCertificateId() {
        return courseCertificateId;
    }

    public void setCourseCertificateId(Long courseCertificateId) {
        this.courseCertificateId = courseCertificateId;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public LocalDate getCourseIssueDate() {
        return courseIssueDate;
    }

    public void setCourseIssueDate(LocalDate courseIssueDate) {
        this.courseIssueDate = courseIssueDate;
    }

    public Person getCoursePerson() {
        return coursePerson;
    }

    public void setCoursePerson(Person coursePerson) {
        this.coursePerson = coursePerson;
    }
}

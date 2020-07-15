package com.jobhunter.education.domain;

import java.time.LocalDate;

public class UniversityCertificate {
    private Long universityCertificateId;
    private String universityNumber;
    private LocalDate universityIssueDate;
    private Person universityPerson;

    public Long getUniversityCertificateId() {
        return universityCertificateId;
    }

    public void setUniversityCertificateId(Long universityCertificateId) {
        this.universityCertificateId = universityCertificateId;
    }

    public String getUniversityNumber() {
        return universityNumber;
    }

    public void setUniversityNumber(String universityNumber) {
        this.universityNumber = universityNumber;
    }

    public LocalDate getUniversityIssueDate() {
        return universityIssueDate;
    }

    public void setUniversityIssueDate(LocalDate universityIssueDate) {
        this.universityIssueDate = universityIssueDate;
    }

    public Person getUniversityPerson() {
        return universityPerson;
    }

    public void setUniversityPerson(Person universityPerson) {
        this.universityPerson = universityPerson;
    }
}

package com.jobhunter.register.domain;


import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "ro_education_certificate")
@Entity
public class EducationCertificate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "education_certificate_id")
    private Long educationCertificateId;
    @Column(name = "certificate_number")
    private String educationNumber;
    @Column(name = "issue_date")
    private LocalDate issueDate;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;

    public Long getEducationCertificateId() {
        return educationCertificateId;
    }

    public void setEducationCertificateId(Long educationCertificateId) {
        this.educationCertificateId = educationCertificateId;
    }

    public String getEducationNumber() {
        return educationNumber;
    }

    public void setEducationNumber(String educationNumber) {
        this.educationNumber = educationNumber;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}

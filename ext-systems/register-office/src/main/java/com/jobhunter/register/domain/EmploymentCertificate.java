package com.jobhunter.register.domain;

import javax.persistence.*;
import java.time.LocalDate;


@Table(name = "ro_employment_certificate")
@Entity
public class EmploymentCertificate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employment_certificate_id")
    private Long employmentCertificateId;
    @Column(name = "certificate_number")
    private String employmentNumber;
    @Column(name = "issue_date")
    private LocalDate issueDate;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;
    @Column(name = "active_status")
    private boolean activeStatus;
    @Column(name = "end_date")
    private LocalDate endDate;

    public Long getEmploymentCertificateId() {
        return employmentCertificateId;
    }

    public void setEmploymentCertificateId(Long employmentCertificateId) {
        this.employmentCertificateId = employmentCertificateId;
    }

    public String getEmploymentNumber() {
        return employmentNumber;
    }

    public void setEmploymentNumber(String employmentNumber) {
        this.employmentNumber = employmentNumber;
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

    public boolean isActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(boolean activeStatus) {
        this.activeStatus = activeStatus;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}

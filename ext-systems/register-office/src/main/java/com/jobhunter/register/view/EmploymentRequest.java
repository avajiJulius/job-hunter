package com.jobhunter.register.view;

import java.time.LocalDate;

public class EmploymentRequest {
    private String firstName;
    private String lastName;
    private LocalDate birthDay;
    private String passportSetia;
    private String passportNumber;
    private LocalDate passportIssueDate;

    private String employmentCertificateNumber;
    private LocalDate employmentCertificateDate;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public String getPassportSetia() {
        return passportSetia;
    }

    public void setPassportSetia(String passportSetia) {
        this.passportSetia = passportSetia;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public LocalDate getPassportIssueDate() {
        return passportIssueDate;
    }

    public void setPassportIssueDate(LocalDate passportIssueDate) {
        this.passportIssueDate = passportIssueDate;
    }

    public String getEmploymentCertificateNumber() {
        return employmentCertificateNumber;
    }

    public void setEmploymentCertificateNumber(String employmentCertificateNumber) {
        this.employmentCertificateNumber = employmentCertificateNumber;
    }

    public LocalDate getEmploymentCertificateDate() {
        return employmentCertificateDate;
    }

    public void setEmploymentCertificateDate(LocalDate employmentCertificateDate) {
        this.employmentCertificateDate = employmentCertificateDate;
    }
}

package com.jobhunter.employeeform.domain;

import java.time.LocalDateTime;

public class EmployeeForm {
    private Long employeeFormId;
    private FormStatus status;
    private LocalDateTime formDate;
    private String post;
    private double salary;
    private Employee employee;
    private Education education;
    private String about;

    public Long getEmployeeFormId() {
        return employeeFormId;
    }

    public void setEmployeeFormId(Long employeeFormId) {
        this.employeeFormId = employeeFormId;
    }

    public FormStatus getStatus() {
        return status;
    }

    public void setStatus(FormStatus status) {
        this.status = status;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDateTime getFormDate() {
        return formDate;
    }

    public void setFormDate(LocalDateTime formDate) {
        this.formDate = formDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}

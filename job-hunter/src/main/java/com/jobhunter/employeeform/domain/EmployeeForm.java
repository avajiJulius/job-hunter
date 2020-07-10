package com.jobhunter.employeeform.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EmployeeForm {
    private Long employeeFormId;
    private String post;
    private FormStatus status;
    private LocalDateTime formDate;
    private Employee employee;
    private List<Job> jobsList;
    private String about;

    public Long getEmployeeFormId() {
        return employeeFormId;
    }

    public void setEmployeeFormId(Long employeeFormId) {
        this.employeeFormId = employeeFormId;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public FormStatus getStatus() {
        return status;
    }

    public void setStatus(FormStatus status) {
        this.status = status;
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

    public List<Job> getJobsList() {
        return jobsList;
    }

    public void addJob(Job job) {
        if(jobsList == null) {
            jobsList = new ArrayList<>(3);
        }
        jobsList.add(job);
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}

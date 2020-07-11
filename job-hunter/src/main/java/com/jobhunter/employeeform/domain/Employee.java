package com.jobhunter.employeeform.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Employee extends Person {
    private String profession;
    private ScheduleStatus scheduleStatus;
    private double experience;
    private List<Job> jobsList;

    public Employee() {
    }

    public Employee(String firstName, String lastName, LocalDate birthDay) {
        super(firstName, lastName, birthDay);
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public ScheduleStatus getScheduleStatus() {
        return scheduleStatus;
    }

    public void setScheduleStatus(ScheduleStatus scheduleStatus) {
        this.scheduleStatus = scheduleStatus;
    }

    public double getExperience() {
        return experience;
    }

    public void setExperience(double experience) {
        this.experience = experience;
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
}

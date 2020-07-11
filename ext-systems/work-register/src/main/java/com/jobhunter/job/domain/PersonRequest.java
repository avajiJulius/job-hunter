package com.jobhunter.job.domain;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

public class PersonRequest {
    private String firstName;
    private String lastName;
    @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
    private LocalDate birthDay;
    private String organization;
    private String post;
    @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
    private LocalDate workStart;
    @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
    private LocalDate workEnd;

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

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public LocalDate getWorkStart() {
        return workStart;
    }

    public void setWorkStart(LocalDate workStart) {
        this.workStart = workStart;
    }

    public LocalDate getWorkEnd() {
        return workEnd;
    }

    public void setWorkEnd(LocalDate workEnd) {
        this.workEnd = workEnd;
    }

    @Override
    public String toString() {
        return "PersonRequest{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDay=" + birthDay +
                ", organization='" + organization + '\'' +
                ", position='" + post + '\'' +
                ", workStart=" + workStart +
                ", workEnd=" + workEnd +
                '}';
    }
}

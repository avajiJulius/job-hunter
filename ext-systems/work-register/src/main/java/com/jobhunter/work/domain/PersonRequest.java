package com.jobhunter.work.domain;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

public class PersonRequest {
    private String firstName;
    private String lastName;
    @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
    private LocalDate birthDay;
    private String organization;
    private String position;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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
                ", position='" + position + '\'' +
                ", workStart=" + workStart +
                ", workEnd=" + workEnd +
                '}';
    }
}

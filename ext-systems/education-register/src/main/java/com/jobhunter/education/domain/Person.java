package com.jobhunter.education.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Table(name = "er_person")
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Long personId;
    @Column(name = "f_name")
    private String firstName;
    @Column(name = "l_name")
    private String lastName;
    @Column(name = "b_day")
    private LocalDate birthDay;
    @OneToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.EAGER, mappedBy = "person")
    private List<UniversityCertificate> universityCertificates;
    @OneToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.EAGER, mappedBy = "person")
    private List<CourseCertificate> courseCertificates;

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

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

    public List<UniversityCertificate> getUniversityCertificates() {
        return universityCertificates;
    }

    public void setUniversityCertificates(List<UniversityCertificate> universityCertificates) {
        this.universityCertificates = universityCertificates;
    }

    public List<CourseCertificate> getCourseCertificates() {
        return courseCertificates;
    }

    public void setCourseCertificates(List<CourseCertificate> courseCertificates) {
        this.courseCertificates = courseCertificates;
    }
}

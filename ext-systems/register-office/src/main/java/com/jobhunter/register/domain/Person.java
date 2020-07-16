package com.jobhunter.register.domain;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Table(name = "ro_person")
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NamedQueries({
        @NamedQuery(name = "Person.findPersons",
                query = "select p from Person p " +
                        "left join fetch p.passports"),
        @NamedQuery(name = "Person.findPersons2",
                query = "select p from Person p " +
                        "left join fetch p.employmentCertificates")
})
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
    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY, mappedBy = "person")
    private List<EmploymentCertificate> employmentCertificates;
    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY, mappedBy = "person")
    private List<EducationCertificate> educationCertificates;
    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY, mappedBy = "person")
    private List<Passport> passports;

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

    public List<Passport> getPassports() {
        return passports;
    }

    public void setPassports(List<Passport> passports) {
        this.passports = passports;
    }

    public List<EmploymentCertificate> getEmploymentCertificates() {
        return employmentCertificates;
    }

    public void setEmploymentCertificates(List<EmploymentCertificate> employmentCertificates) {
        this.employmentCertificates = employmentCertificates;
    }

    public List<EducationCertificate> getEducationCertificates() {
        return educationCertificates;
    }

    public void setEducationCertificates(List<EducationCertificate> educationCertificates) {
        this.educationCertificates = educationCertificates;
    }
}

package com.jobhunter.register.dao;

import com.jobhunter.register.domain.Person;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PersonDaoTest {

    @Test
    public void findPersons() {
        PersonDao dao = new PersonDao();
        List<Person> persons = dao.findPersons();

        persons.forEach(person -> {
            System.out.println(person.getClass().getName());
            System.out.println(person.getFirstName());
            System.out.println(person.getPassports().size());
            System.out.println(person.getEmploymentCertificates().size());}
        );
    }
}
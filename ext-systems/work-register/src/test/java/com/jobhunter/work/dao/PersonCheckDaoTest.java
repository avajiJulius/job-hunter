package com.jobhunter.work.dao;

import com.jobhunter.work.domain.PersonRequest;
import com.jobhunter.work.domain.PersonResponse;
import com.jobhunter.work.exception.PersonCheckException;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class PersonCheckDaoTest {

    @Test
    public void checkPerson() throws PersonCheckException {
        PersonRequest pr = new PersonRequest();
        pr.setFirstName("Alexandr");
        pr.setLastName("Matushkin");
        pr.setBirthDay(LocalDate.of(2000, 2, 12));
        pr.setOrganization("Yat");
        pr.setPosition("administrator");
        pr.setWorkStart(LocalDate.of(2018, 9, 15));
        pr.setWorkEnd(LocalDate.of(2020, 2, 7));

        PersonCheckDao dao = new PersonCheckDao();
        dao.setConnectionBuilder(new DirectConnectionBuilder());
        PersonResponse response = dao.checkPerson(pr);


        Assert.assertTrue(response.isWorked());
        Assert.assertFalse(response.isPartial());
    }

    @Test
    public void checkPerson2() throws PersonCheckException {
        PersonRequest pr = new PersonRequest();
        pr.setFirstName("Polina");
        pr.setLastName("Kuznetsova");
        pr.setBirthDay(LocalDate.of(2001, 2, 16));
        pr.setOrganization("Meria");
        pr.setPosition("manager");
        pr.setWorkStart(LocalDate.of(2020, 7, 7));
        pr.setWorkEnd(null);

        PersonCheckDao dao = new PersonCheckDao();
        dao.setConnectionBuilder(new DirectConnectionBuilder());
        PersonResponse response = dao.checkPerson(pr);


        Assert.assertTrue(response.isWorked());
        Assert.assertFalse(response.isPartial());
    }
}
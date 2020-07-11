package com.jobhunter.employeeform.dao;

import com.jobhunter.employeeform.domain.*;
import com.jobhunter.employeeform.exception.DaoException;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.*;

public class EmployeeFormDaoImplTest {

    @BeforeClass
    public static void startUp() throws Exception {
        DBInit.startUp();
    }

    @Test
    public void saveEmployeeForm() throws DaoException {
        EmployeeForm ef = buildEmployeeForm(10L);
        Long id = new EmployeeFormDaoImpl().saveEmployeeForm(ef);
    }

    private EmployeeForm buildEmployeeForm(long i) {
        EmployeeForm ef = new EmployeeForm();
        ef.setEmployeeFormId(i);
        ef.setStatus(FormStatus.fromValue(1));
        ef.setFormDate(LocalDateTime.now());
        ef.setPost("Junior Java Developer");
        ef.setSalary(40000);

        Employee e = new Employee("Alexandr", "Matushkin", LocalDate.of(2000, 2,12));
        City city = new City(1L, "Saint-Petersburg");
        e.setCurrentCity(city);
        e.setEmail("avajiJulius@icloud.com");
        e.setProfession("Java developer");
        e.setScheduleStatus(ScheduleStatus.fromValue(2));
        e.setExperience(2.1);

        Job job = new Job("Yat", "administrator", LocalDate.of(2018, 9, 15),
                LocalDate.of(2020, 2, 7));
        e.addJob(job);

        Education education = new Education(new University(1L, "Herzen University")
                , new Course(1L, "CS50"));
        ef.setAbout(null);

        ef.setEmployee(e);
        ef.setEducation(education);

        return ef;
    }

    @Test
    public void getEmployeeForm() throws DaoException {
        List<EmployeeForm> list = new EmployeeFormDaoImpl().getEmployeeForm();
    }
}
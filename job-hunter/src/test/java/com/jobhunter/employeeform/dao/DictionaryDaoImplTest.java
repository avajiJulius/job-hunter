package com.jobhunter.employeeform.dao;

import com.jobhunter.employeeform.domain.City;
import com.jobhunter.employeeform.domain.Course;
import com.jobhunter.employeeform.domain.University;
import com.jobhunter.employeeform.exception.DaoException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

public class DictionaryDaoImplTest {

    @BeforeClass
    public static void startUp() throws Exception {
        DBInit.startUp();
    }

    @Test
    public void testCity() throws DaoException {
        List<City> cityList = new DictionaryDaoImpl().findCity("BURG");
        Assert.assertTrue(cityList.size() == 2);
        Assert.assertFalse(cityList.size() == 3);
    }

    @Test
    public void testUniversity() throws DaoException {
        List<University> universityList = new DictionaryDaoImpl().findUniversity("E");
        Assert.assertTrue(universityList.size() == 2);
        Assert.assertFalse(universityList.size() == 3);
    }

    @Test
    public void testCourse() throws DaoException {
        List<Course> courseList = new DictionaryDaoImpl().findCourse("1");
        Assert.assertTrue(courseList.size() == 0);
        Assert.assertFalse(courseList.size() == 2);
    }
}

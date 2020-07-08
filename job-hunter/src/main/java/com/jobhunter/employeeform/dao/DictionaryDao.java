package com.jobhunter.employeeform.dao;

import com.jobhunter.employeeform.domain.City;
import com.jobhunter.employeeform.domain.Course;
import com.jobhunter.employeeform.domain.University;
import com.jobhunter.employeeform.exception.DaoException;

import java.util.List;

public interface DictionaryDao {
    List<City> findCity(String cityName) throws DaoException;
    List<University> findUniversity(String universityName) throws DaoException;
    List<Course> findCourse(String courseName) throws DaoException;
}

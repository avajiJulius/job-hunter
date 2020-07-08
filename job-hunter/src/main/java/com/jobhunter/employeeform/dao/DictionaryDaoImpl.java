package com.jobhunter.employeeform.dao;

import com.jobhunter.employeeform.domain.City;
import com.jobhunter.employeeform.domain.Course;
import com.jobhunter.employeeform.domain.University;
import com.jobhunter.employeeform.exception.DaoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DictionaryDaoImpl implements DictionaryDao {

    private static final Logger logger = LoggerFactory.getLogger(DictionaryDaoImpl.class);

    private static final String GET_CITY = "select city_id, city_name from jh_cities " +
            "where upper(city_name) like upper(?)";

    private static final String GET_UNIVERSITY = "select university_id, university_name from jh_universities " +
            "where upper(university_name) like upper(?)";

    private static final String GET_COURSE = "select course_id, course_name from jh_courses " +
            "where upper(course_name) like upper(?)";

    private Connection getConnection() throws SQLException {
        return ConnectionBuilder.getConnection();
    }

    @Override
    public List<City> findCity(String cityName) throws DaoException {
        List<City> result = new LinkedList<>();

        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(GET_CITY)) {

            stmt.setString(1, "%" + cityName + "%");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                City city = new City(rs.getLong("city_id"),
                        rs.getString("city_name"));
                result.add(city);
            }

        } catch (SQLException ex) {
            logger.error(ex.getMessage(), ex);
            throw new DaoException(ex);
        }

        return result;
    }

    @Override
    public List<University> findUniversity(String universityName) throws DaoException {
        List<University> result = new LinkedList<>();

        try(Connection connection = getConnection();
        PreparedStatement stmt = connection.prepareStatement(GET_UNIVERSITY)) {

            stmt.setString(1,"%" + universityName + "%");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                University university = new University(rs.getLong("university_id"),
                        rs.getString("university_name"));
                result.add(university);
            }
        } catch (SQLException ex) {
            logger.error(ex.getMessage(), ex);
            throw new DaoException(ex);
        }

        return result;
    }

    @Override
    public List<Course> findCourse(String courseName) throws DaoException {
        List<Course> result = new LinkedList<>();

        try(Connection connection = getConnection();
        PreparedStatement stmt = connection.prepareStatement(GET_COURSE)) {

            stmt.setString(1,"%" + courseName + "%");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                Course course = new Course(rs.getLong("course_id"),
                        rs.getString("course_name"));
                result.add(course);
            }

        } catch (SQLException ex) {
            logger.error(ex.getMessage(), ex);
            throw new DaoException(ex);
        }
        return result;
    }
}

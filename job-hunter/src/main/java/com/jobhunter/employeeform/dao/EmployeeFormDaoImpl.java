package com.jobhunter.employeeform.dao;

import com.jobhunter.employeeform.config.Config;
import com.jobhunter.employeeform.domain.*;
import com.jobhunter.employeeform.exception.DaoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeFormDaoImpl implements EmployeeFormDao {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeFormDaoImpl.class);

    private static final String INSERT_FORM = "insert into jh_employee_forms(" +
            "e_form_status, e_form_date, e_form_post, salary, f_name, l_name, " +
            "b_day, city_id, email, profession, schedule_status, " +
            "experience, university_id, course_id, about) " +
            "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String INSERT_JOB = "insert into jh_jobs(" +
            "e_form_id, organization, post, work_start, work_end) " +
            "values (?, ?, ?, ?, ?)";

    private static final String SELECT_FORMS = "select ef.*, ct.city_name, u.university_name, cr.course_name " +
            "from jh_employee_forms ef " +
            "inner join jh_cities ct on ct.city_id = ef.city_id " +
            "inner join jh_universities u on u.university_id = ef.university_id " +
            "inner join jh_courses cr on cr.course_id = ef.course_id " +
            "where e_form_status = ? order by ef.e_form_date";

    private static final String SELECT_JOBS = "select j.* from jh_jobs j " +
            "where j.e_form_id in ";

    private static final String SELECT_FORMS_FULL = "select ef.*, " +
            "ct.city_name, u.university_name, cr.course_name, j.* " +
            "from jh_employee_forms ef " +
            "inner join jh_jobs j on j.e_form_id = ef.e_form_id " +
            "inner join jh_cities ct on ct.city_id = ef.city_id " +
            "inner join jh_universities u on u.university_id = ef.university_id " +
            "inner join jh_courses cr on cr.course_id = ef.course_id " +
            "where e_form_status = ? order by ef.e_form_id limit ?";


    public Connection getConnection() throws SQLException {
        return ConnectionBuilder.getConnection();
    }

    @Override
    public Long saveEmployeeForm(EmployeeForm ef) throws DaoException {
        Long result = -1L;

        try(Connection con = getConnection();
            PreparedStatement stmt = con.prepareStatement(INSERT_FORM, new String[] {"e_form_id"})) {

            con.setAutoCommit(false);
            try{
                stmt.setInt(1, FormStatus.UNCHECKED.ordinal());
                stmt.setTimestamp(2, java.sql.Timestamp.valueOf(LocalDateTime.now()));
                stmt.setString(3, ef.getPost());
                stmt.setDouble(4, ef.getSalary());
                stmt.setString(15, ef.getAbout());

                //Employee Data
                Employee e = ef.getEmployee();
                stmt.setString(5, e.getFirstName());
                stmt.setString(6, e.getLastName());
                stmt.setDate(7, java.sql.Date.valueOf(e.getBirthDay()));
                stmt.setLong(8, e.getCurrentCity().getCityId());
                stmt.setString(9, e.getEmail());
                stmt.setString(10, e.getProfession());
                stmt.setInt(11, ScheduleStatus.UNSELECTED.ordinal());
                stmt.setDouble(12, e.getExperience());

                stmt.setLong(13, ef.getEducation().getUniversity().getUniversityId());
                stmt.setLong(14, ef.getEducation().getCourse().getCourseId());

                stmt.executeUpdate();

                ResultSet rs = stmt.getGeneratedKeys();
                if(rs.next()) {
                    result = rs.getLong(1);
                }
                rs.close();

                saveJob(con, ef, result);

                con.commit();

            } catch (SQLException ex) {
                con.rollback();
                throw ex;
            }

        } catch (SQLException ex) {
            logger.error(ex.getMessage(), ex);
            throw new DaoException(ex);
        }

        return result;
    }

    private void saveJob(Connection con, EmployeeForm ef, Long efId) throws SQLException{
        try(PreparedStatement stmt = con.prepareStatement(INSERT_JOB)) {
            for(Job job : ef.getEmployee().getJobsList()) {
                stmt.setLong(1, efId);
                stmt.setString(2, job.getOrganization());
                stmt.setString(3, job.getPost());
                stmt.setDate(4,java.sql.Date.valueOf(job.getWorkStart()));
                stmt.setDate(5,java.sql.Date.valueOf(job.getWorkEnd()));
                stmt.addBatch();
            }
            stmt.executeBatch();
        }
    }

    @Override
    public List<EmployeeForm> getEmployeeForm() throws DaoException {
        //return getEmployeeFormTwoSelect();
        return getEmployeeFormOneSelect();
    }

    private List<EmployeeForm> getEmployeeFormOneSelect() throws DaoException{
        List<EmployeeForm> result = new LinkedList<>();

        try(Connection con = getConnection();
        PreparedStatement stmt = con.prepareStatement(SELECT_FORMS_FULL)) {

            Map<Long, EmployeeForm> maps = new HashMap<>();
            stmt.setInt(1, FormStatus.UNCHECKED.ordinal());
            int limit = Integer.parseInt(Config.getProperty(Config.DB_LIMIT));
            stmt.setInt(2, limit);

            ResultSet rs = stmt.executeQuery();
            int counter = 0;
            while(rs.next()) {
                Long efId = rs.getLong("e_form_id");
                if(!maps.containsKey(efId)) {
                    EmployeeForm ef = getFullEmployeeForm(rs);
                    result.add(ef);
                    maps.put(efId, ef);
                }

                EmployeeForm ef = maps.get(efId);
                ef.getEmployee().addJob(fillJob(rs));
                counter++;
            }
            if(counter >= limit) {
                result.remove(result.size() - 1);
            }

            rs.close();

        } catch (SQLException ex) {
            logger.error(ex.getMessage(), ex);
            throw new DaoException(ex);
        }

        return result;
    }


    private List<EmployeeForm> getEmployeeFormTwoSelect() throws DaoException {
        List<EmployeeForm> result = new LinkedList<>();

        try(Connection con = getConnection();
        PreparedStatement stmt = con.prepareStatement(SELECT_FORMS)) {

            stmt.setInt(1, FormStatus.UNCHECKED.ordinal());
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                EmployeeForm ef = getFullEmployeeForm(rs);

                result.add(ef);
            }

            findJobs(con, result);

            rs.close();

        } catch (SQLException ex) {
            logger.error(ex.getMessage(), ex);
            throw new DaoException(ex);
        }

        return result;
    }


    private EmployeeForm getFullEmployeeForm(ResultSet rs) throws SQLException{
        EmployeeForm ef = new EmployeeForm();

        fillEmployeeFrom(rs, ef);
        ef.setEmployee(fillEmployee(rs));

        return ef;
    }

    private void fillEmployeeFrom(ResultSet rs, EmployeeForm ef) throws SQLException {
        ef.setEmployeeFormId(rs.getLong("e_form_id"));
        ef.setStatus(FormStatus.fromValue(rs.getInt("e_form_status")));
        ef.setFormDate(rs.getTimestamp("e_form_date").toLocalDateTime());
        ef.setPost(rs.getString("e_form_post"));
        ef.setSalary(rs.getDouble("salary"));
        ef.setAbout(rs.getString("about"));

        //Education
        Long universityId = rs.getLong("university_id");
        String universityName = rs.getString("university_name");
        University university = new University(universityId, universityName);
        Long courseId = rs.getLong("course_id");
        String courseName = rs.getString("course_name");
        Course course = new Course(courseId, courseName);
        Education education = new Education(university, course);
        ef.setEducation(education);
    }

    private Employee fillEmployee(ResultSet rs) throws SQLException {
    Employee e = new Employee();

    e.setFirstName(rs.getString("f_name"));
    e.setLastName(rs.getString("l_name"));
    e.setBirthDay(rs.getDate("b_day").toLocalDate());

    //City
    Long cityId = rs.getLong("city_id");
    String cityName = rs.getString("city_name");
    City city = new City(cityId, cityName);
    e.setCurrentCity(city);

    e.setEmail(rs.getString("email"));

    e.setProfession(rs.getString("profession"));
    e.setScheduleStatus(ScheduleStatus.fromValue(rs.getInt("schedule_status")));
    e.setExperience(rs.getDouble("experience"));


    return e;
    }

    private void findJobs(Connection con, List<EmployeeForm> result) throws SQLException {
        String jl = "(" + result.stream().map(ef -> String.valueOf(ef.getEmployeeFormId()))
                .collect(Collectors.joining(",")) + ")";

        Map<Long, EmployeeForm> maps = result.stream()
                .collect(Collectors.toMap(ef -> ef.getEmployeeFormId(), ef -> ef));

        try(PreparedStatement stmt = con.prepareStatement(SELECT_JOBS + jl)) {
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                Job job = fillJob(rs);
                EmployeeForm ef = maps.get(rs.getLong("e_form_id"));
                ef.getEmployee().addJob(job);
            }
        }
    }

    private Job fillJob(ResultSet rs) throws SQLException{
        Job job = new Job();
        job.setOrganization(rs.getString("organization"));
        job.setPost(rs.getString("post"));
        job.setWorkStart(rs.getDate("work_start").toLocalDate());
        job.setWorkEnd(rs.getDate("work_end").toLocalDate());
        return job;
    }

}

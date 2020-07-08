package com.jobhunter.employeeform.dao;

import com.jobhunter.employeeform.domain.Employee;
import com.jobhunter.employeeform.domain.EmployeeForm;
import com.jobhunter.employeeform.exception.DaoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public class EmployeeFormDaoImpl implements EmployeeFormDao {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeFormDaoImpl.class);

    private static final String INSERT_FORM = "insert into jh_employee_forms(" +
            "e_form_post, e_form_status, e_form_date, f_name, l_name " +
            "b_day, city_id, email, profession, schedule_status " +
            "experience, salary, university_id, course_id, about) " +
            "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String INSERT_JOB = "";

    private static final String SELECT_FORMS = "";

    private static final String SELECT_JOBS = "";


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
                stmt.setString(1, ef.getPost());
                stmt.setInt(2, ef.getStatus());
                stmt.setTimestamp(3, java.sql.Timestamp.valueOf(LocalDateTime.now()));
                stmt.setString(15, ef.getAbout());

                //Employee Data
                Employee e = ef.getEmployee();
                stmt.setString(4, e.getFirstName());
                stmt.setString(5, e.getLastName());
                stmt.setDate(6, java.sql.Date.valueOf(e.getBirthDay()));
                stmt.setLong(7, e.getCurrentCity().getCityId());
                stmt.setString(8, e.getEmail());
                stmt.setString(9, e.getProfession());
                stmt.setInt(10, e.getScheduleStatus());
                stmt.setDouble(11, e.getExperience());
                stmt.setDouble(12, e.getSalary());
                stmt.setLong(13, e.getEducation().getUniversity().getUniversityId());
                stmt.setLong(14, e.getEducation().getCourse().getCourseId());

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

    private void saveJob(Connection con, EmployeeForm ef, Long result) {
    }

    @Override
    public List<EmployeeForm> getEmployeeForm() throws DaoException {
        return null;
    }
}

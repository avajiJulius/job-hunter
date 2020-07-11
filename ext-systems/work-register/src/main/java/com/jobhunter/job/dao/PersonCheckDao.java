package com.jobhunter.job.dao;

import com.jobhunter.job.domain.PersonRequest;
import com.jobhunter.job.domain.PersonResponse;
import com.jobhunter.job.exception.PersonCheckException;

import java.sql.*;

public class PersonCheckDao {

    private static final String SQL_REQUEST = "select partial from jr_person_job pj " +
            "inner join jr_person p on p.person_id = pj.person_id " +
            "inner join jr_job j on j.job_id = pj.job_id  " +
            "where " +
            "upper(p.f_name) = upper(?) " +
            "and upper(p.l_name) = upper(?) " +
            "and p.b_day = ? " +
            "and upper(j.organization) = upper(?) " +
            "and upper(j.post) = upper(?)" +
            "and j.work_start = ? ";

    private ConnectionBuilder connectionBuilder;

    public void setConnectionBuilder(ConnectionBuilder connectionBuilder) {
        this.connectionBuilder = connectionBuilder;
    }

    private Connection getConnection() throws SQLException{
        return connectionBuilder.getConnection();
    }

    public PersonResponse checkPerson(PersonRequest request) throws PersonCheckException {
        PersonResponse response = new PersonResponse();

        String sql = SQL_REQUEST;
        if (request.getWorkEnd() != null) {
            sql += "and j.work_end = ?";
        } else {
            sql += "and j.work_end is null";
        }

        try(Connection connection = getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, request.getFirstName());
            stmt.setString(2, request.getLastName());
            stmt.setDate(3, java.sql.Date.valueOf(request.getBirthDay()));
            stmt.setString(4, request.getOrganization());
            stmt.setString(5, request.getPost());
            stmt.setDate(6, java.sql.Date.valueOf(request.getWorkStart()));
            if (request.getWorkEnd() != null) {
                stmt.setDate(7, java.sql.Date.valueOf(request.getWorkEnd()));
            }
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                response.setWorked(true);
                response.setPartial(rs.getBoolean("partial"));
            }

        } catch (SQLException ex) {
            throw new PersonCheckException();
        }

        return response;
    }

}

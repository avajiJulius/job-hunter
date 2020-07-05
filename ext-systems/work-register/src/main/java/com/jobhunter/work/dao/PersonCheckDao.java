package com.jobhunter.work.dao;

import com.jobhunter.work.domain.PersonRequest;
import com.jobhunter.work.domain.PersonResponse;
import com.jobhunter.work.exception.PersonCheckException;

import java.sql.*;

public class PersonCheckDao {

    private static final String SQL_REQUEST = "select partial from wr_person_work pw " +
            "inner join wr_person p on p.person_id = pw.person_id " +
            "inner join wr_last_work lw on lw.last_work_id = pw.last_work_id  " +
            "where " +
            "upper(p.f_name) = upper(?) " +
            "and upper(p.l_name) = upper(?) " +
            "and p.b_day = ? " +
            "and upper(lw.organization) = upper(?) " +
            "and upper(lw.position) = upper(?)" +
            "and lw.work_start = ? ";

    public PersonResponse checkPerson(PersonRequest request) throws PersonCheckException {
        PersonResponse response = new PersonResponse();

        String sql = SQL_REQUEST;
        if (request.getWorkEnd() != null) {
            sql += "and lw.work_end = ?";
        } else {
            sql += "and lw.work_end is null";
        }

        try(Connection connection = getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, request.getFirstName());
            stmt.setString(2, request.getLastName());
            stmt.setDate(3, java.sql.Date.valueOf(request.getBirthDay()));
            stmt.setString(4, request.getOrganization());
            stmt.setString(5, request.getPosition());
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

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost/work_register",
                "postgres", "developer");
    }
}

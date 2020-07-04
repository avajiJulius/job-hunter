package com.jobhunter.work.dao;

import com.jobhunter.work.domain.PersonRequest;
import com.jobhunter.work.domain.PersonResponse;
import com.jobhunter.work.exception.PersonCheckException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonCheckDao {

    private static final String SQL_REQUEST = "";

    public PersonResponse checkPerson(PersonRequest request) throws PersonCheckException {
        PersonResponse response = new PersonResponse();

        try(Connection connection = getConnection();
            PreparedStatement stmt = connection.prepareStatement(SQL_REQUEST)) {

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

    private Connection getConnection() {
        return null
    }
}

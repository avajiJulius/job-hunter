package com.jobhunter.employeeform.dao;

import org.junit.BeforeClass;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Statement;
import java.util.List;
import java.util.stream.Collectors;

public class DBInit {

    @BeforeClass
    public static void startUp() throws Exception {
        URL url = DictionaryDaoImplTest.class.getClassLoader().getResource("jh_employee_form.sql");

        List<String> str = Files.readAllLines(Paths.get(url.toURI()));
        String sql = str.stream().collect(Collectors.joining());

        try(Connection con = ConnectionBuilder.getConnection();
             Statement stmt = con.createStatement()) {

             stmt.executeUpdate(sql);

         }
    }
}

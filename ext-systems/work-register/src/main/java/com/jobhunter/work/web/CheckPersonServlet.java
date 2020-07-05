package com.jobhunter.work.web;

import com.jobhunter.work.dao.PersonCheckDao;
import com.jobhunter.work.domain.PersonRequest;
import com.jobhunter.work.domain.PersonResponse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "CheckPersonServlet", urlPatterns = {"/checkPerson"})
public class CheckPersonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        PersonRequest pr = new PersonRequest();
        pr.setFirstName(firstName);
        pr.setLastName(lastName);
        pr.setBirthDay(LocalDate.of(2001, 2, 16));
        pr.setOrganization("Meria");
        pr.setPosition("manager");
        pr.setWorkStart(LocalDate.of(2020, 7, 7));
        pr.setWorkEnd(null);

        try {
            PersonCheckDao dao = new PersonCheckDao();
            PersonResponse response = dao.checkPerson(pr);
            if(response.isWorked()) {
                resp.getWriter().write("Worked at this job");
            } else {
                resp.getWriter().write(("Don't worked"));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

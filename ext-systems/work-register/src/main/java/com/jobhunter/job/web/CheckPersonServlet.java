package com.jobhunter.job.web;

import com.jobhunter.job.dao.PersonCheckDao;
import com.jobhunter.job.domain.PersonRequest;
import com.jobhunter.job.domain.PersonResponse;
import com.jobhunter.job.dao.PoolConnectionBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "CheckPersonServlet", urlPatterns = {"/checkPerson"})
public class CheckPersonServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(CheckPersonServlet.class);

    private PersonCheckDao dao;

    @Override
    public void init() throws ServletException {
        logger.info("SERVLET IS CREATED");
        dao = new PersonCheckDao();
        dao.setConnectionBuilder(new PoolConnectionBuilder());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        PersonRequest pr = new PersonRequest();
        pr.setFirstName(req.getParameter("firstName"));
        pr.setLastName(req.getParameter("lastName"));
        LocalDate birthDay = LocalDate.parse(req.getParameter("birthDay"), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        pr.setBirthDay(birthDay);
        pr.setOrganization(req.getParameter("organization"));
        pr.setPost(req.getParameter("post"));
        LocalDate workStart = LocalDate.parse(req.getParameter("workStart"), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        pr.setWorkStart(workStart);
        LocalDate workEnd = LocalDate.parse(req.getParameter("workEnd"), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        pr.setWorkEnd(workEnd);

        try {
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

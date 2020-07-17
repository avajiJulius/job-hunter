package com.jobhunter.register.buisness;

import com.jobhunter.register.dao.EmploymentDao;
import com.jobhunter.register.dao.PersonDao;
import com.jobhunter.register.domain.EmploymentCertificate;
import com.jobhunter.register.domain.Person;
import com.jobhunter.register.view.EmploymentRequest;
import com.jobhunter.register.view.EmploymentResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service("manager")
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class EmploymentManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmploymentManager.class);

    private EmploymentDao employmentDao;
    @Autowired
    private PersonDao personDao;

    @Autowired
    public void setEmploymentDao(EmploymentDao employmentDao) {
        this.employmentDao = employmentDao;
    }

    @Transactional
    public EmploymentResponse findEmploymentCertificate(EmploymentRequest request) {
        LOGGER.info("findEmploymentCertificate called");

        Person p = new Person();
        p.setFirstName("Vlad");
        p.setLastName("Samarov");
        p.setBirthDay(LocalDate.of(1998, 04, 26));
        personDao.addPerson(p);

        EmploymentCertificate ec = getEmploymentCertificate();
        employmentDao.saveAndFlush(ec);
        employmentDao.findAll();

        return new EmploymentResponse();
    }

    public EmploymentCertificate getEmploymentCertificate() {
        EmploymentCertificate ec = new EmploymentCertificate();
        ec.setIssueDate(LocalDate.now());
        ec.setEmploymentNumber("123456");
        ec.setActiveStatus(true);
        List<Person> persons = personDao.findPersons();
        persons.forEach(p -> ec.setPerson(p));

        return ec;
    }
}

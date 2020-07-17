package com.jobhunter.register.dao;

import com.jobhunter.register.domain.EmploymentCertificate;
import com.jobhunter.register.view.EmploymentRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class EmploymentDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmploymentDao.class);

    @PersistenceContext
    private EntityManager entityManager;
    @Value("${test.value}")
    private String test;

    public void setTest(String test) {
        this.test = test;
    }

    public EmploymentCertificate findEmploymentCertificate(EmploymentRequest request) {
        LOGGER.info("findEmploymentCertificate called:{}", test);
        return null;
    }
}

package com.jobhunter.register.dao;

import com.jobhunter.register.domain.EmploymentCertificate;
import com.jobhunter.register.view.EmploymentRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.persistence.EntityManager;

public class EmploymentDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmploymentDao.class);

    private EntityManager entityManager;
    private String test;

    public void setTest(String test) {
        this.test = test;
    }

    public EmploymentCertificate findEmploymentCertificate(EmploymentRequest request) {
        LOGGER.info("findEmploymentCertificate called:{}", test);
        return null;
    }
}

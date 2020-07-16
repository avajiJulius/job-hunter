package com.jobhunter.register.buisness;

import com.jobhunter.register.dao.EmploymentDao;
import com.jobhunter.register.domain.EmploymentCertificate;
import com.jobhunter.register.view.EmploymentRequest;
import com.jobhunter.register.view.EmploymentResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmploymentManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmploymentManager.class);

    private EmploymentDao employmentDao;

    public void setEmploymentDao(EmploymentDao employmentDao) {
        this.employmentDao = employmentDao;
    }

    public EmploymentResponse findEmploymentCertificate(EmploymentRequest request) {
        LOGGER.info("findEmploymentCertificate called");
        EmploymentCertificate certificate = employmentDao.findEmploymentCertificate(request);

        return new EmploymentResponse();
    }
}

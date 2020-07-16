package com.jobhunter.register.rest;

import com.jobhunter.register.buisness.EmploymentManager;
import com.jobhunter.register.view.EmploymentRequest;
import com.jobhunter.register.view.EmploymentResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmploymentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmploymentController.class);

    private EmploymentManager employmentManager;

    public void setEmploymentManager(EmploymentManager employmentManager) {
        this.employmentManager = employmentManager;
    }

    public EmploymentResponse findEmploymentCertificate(EmploymentRequest request) {
        LOGGER.info("findEmploymentCertificate called");
        return employmentManager.findEmploymentCertificate(request);
    }
}

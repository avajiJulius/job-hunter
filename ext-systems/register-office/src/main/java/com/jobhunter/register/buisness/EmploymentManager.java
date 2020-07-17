package com.jobhunter.register.buisness;

import com.jobhunter.register.dao.EmploymentDao;
import com.jobhunter.register.dao.PersonDao;
import com.jobhunter.register.domain.EmploymentCertificate;
import com.jobhunter.register.view.EmploymentRequest;
import com.jobhunter.register.view.EmploymentResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

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

    public EmploymentResponse findEmploymentCertificate(EmploymentRequest request) {
        LOGGER.info("findEmploymentCertificate called");
        EmploymentCertificate certificate = employmentDao.findEmploymentCertificate(request);

        PersonDao dao = new PersonDao();

        return new EmploymentResponse();
    }
}

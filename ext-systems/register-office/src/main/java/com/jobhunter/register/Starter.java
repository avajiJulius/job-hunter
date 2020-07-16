package com.jobhunter.register;

import com.jobhunter.register.rest.EmploymentController;
import com.jobhunter.register.view.EmploymentRequest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Starter {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"springContext.xml"});

        EmploymentController controller = context.getBean("controller", EmploymentController.class);
        controller.findEmploymentCertificate(new EmploymentRequest());
    }
}

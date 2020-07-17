package com.jobhunter.register.config;

import com.jobhunter.register.dao.PersonDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = {"classpath:/register.properties"})
public class EmploymentConfig {

    @Bean
    public PersonDao buildPersonDao() {
        System.out.println("Create PersonDao");
        return new PersonDao();
    }
}

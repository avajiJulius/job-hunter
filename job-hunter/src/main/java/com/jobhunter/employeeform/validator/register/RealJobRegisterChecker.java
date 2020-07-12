package com.jobhunter.employeeform.validator.register;

import com.jobhunter.employeeform.config.Config;
import com.jobhunter.employeeform.domain.Employee;
import com.jobhunter.employeeform.domain.register.JobRegisterRequest;
import com.jobhunter.employeeform.domain.register.JobRegisterResponse;
import com.jobhunter.employeeform.exception.JobRegisterException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

public class RealJobRegisterChecker implements JobRegisterChecker {
    @Override
    public JobRegisterResponse checkEmployee(Employee employee) throws JobRegisterException {
        try {
            JobRegisterRequest request = new JobRegisterRequest(employee);


            Client client = ClientBuilder.newClient();
            JobRegisterResponse response = client.target(Config.getProperty(Config.JR_URL))
                    .request(MediaType.APPLICATION_JSON)
                    .post(Entity.entity(request, MediaType.APPLICATION_JSON))
                    .readEntity(JobRegisterResponse.class);
            return response;
        } catch (Exception ex) {
            throw new JobRegisterException(ex.getMessage(), ex, "13");
        }
    }
}

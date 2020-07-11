package com.jobhunter.employeeform.validator.register;

import com.jobhunter.employeeform.domain.Employee;
import com.jobhunter.employeeform.domain.register.JobRegisterRequest;
import com.jobhunter.employeeform.domain.register.JobRegisterResponse;
import com.jobhunter.employeeform.exception.JobRegisterException;

public class RealJobRegisterChecker implements JobRegisterChecker {
    @Override
    public JobRegisterResponse checkEmployee(Employee employee) throws JobRegisterException {
        return null;
    }
}

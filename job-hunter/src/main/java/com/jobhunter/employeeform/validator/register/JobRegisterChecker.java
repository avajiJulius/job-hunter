package com.jobhunter.employeeform.validator.register;

import com.jobhunter.employeeform.domain.Employee;
import com.jobhunter.employeeform.domain.register.JobRegisterResponse;
import com.jobhunter.employeeform.exception.JobRegisterException;

public interface JobRegisterChecker {
    JobRegisterResponse checkEmployee(Employee employee) throws JobRegisterException;
}

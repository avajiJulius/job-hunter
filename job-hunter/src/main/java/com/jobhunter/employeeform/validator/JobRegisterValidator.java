package com.jobhunter.employeeform.validator;

import com.jobhunter.employeeform.domain.Employee;
import com.jobhunter.employeeform.domain.EmployeeForm;
import com.jobhunter.employeeform.domain.Job;
import com.jobhunter.employeeform.domain.register.AnswerJobRegister;
import com.jobhunter.employeeform.domain.register.AnswerJobRegisterItem;
import com.jobhunter.employeeform.domain.register.JobRegisterResponse;
import com.jobhunter.employeeform.exception.JobRegisterException;
import com.jobhunter.employeeform.validator.register.JobRegisterChecker;
import com.jobhunter.employeeform.validator.register.RealJobRegisterChecker;

public class JobRegisterValidator {

    public static final String IN_CODE = "NO_JR";

    private JobRegisterChecker employeeChecker;

    public JobRegisterValidator() {
        employeeChecker = new RealJobRegisterChecker();
    }

    public AnswerJobRegister checkJobRegister(EmployeeForm ef) {
        AnswerJobRegister ajr = new AnswerJobRegister();

        ajr.addItem(checkEmployee(ef.getEmployee()));

        return ajr;
    }

    private AnswerJobRegisterItem checkEmployee(Employee employee) {
        AnswerJobRegisterItem.JobStatus status = null;
        AnswerJobRegisterItem.JobError error = null;

        try {
            JobRegisterResponse response = employeeChecker.checkEmployee(employee);
            status = response.isWorked() ? AnswerJobRegisterItem.JobStatus.CONFIRMED : AnswerJobRegisterItem.JobStatus.NOT_CONFIRMED;
        } catch (JobRegisterException ex) {
            ex.printStackTrace();
            status = AnswerJobRegisterItem.JobStatus.ERROR;
            error = new AnswerJobRegisterItem.JobError(ex.getCode(), ex.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
            status = AnswerJobRegisterItem.JobStatus.ERROR;
            error = new AnswerJobRegisterItem.JobError(IN_CODE, ex.getMessage());
        }

        AnswerJobRegisterItem ans = new AnswerJobRegisterItem(status, employee, error);

        return ans;

    }
}

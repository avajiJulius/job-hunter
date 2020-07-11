package com.jobhunter.employeeform;

import com.jobhunter.employeeform.dao.EmployeeFormDaoImpl;
import com.jobhunter.employeeform.domain.EmployeeForm;
import com.jobhunter.employeeform.domain.register.AnswerJobRegister;
import com.jobhunter.employeeform.exception.DaoException;
import com.jobhunter.employeeform.validator.EducationRegisterValidator;
import com.jobhunter.employeeform.validator.JobRegisterValidator;
import com.jobhunter.employeeform.validator.MailSenderValidator;

import java.util.List;

public class EmployeeFormValidator {
    private JobRegisterValidator jobVal;
    private MailSenderValidator mailVal;
    private EducationRegisterValidator educationVal;

    public EmployeeFormValidator() {
        jobVal = new JobRegisterValidator();
        mailVal = new MailSenderValidator();
        educationVal = new EducationRegisterValidator();
    }

    public static void main(String[] args){
        EmployeeFormValidator efv = new EmployeeFormValidator();
        efv.checkAll();
    }

    private void checkAll() {
        try{
            List<EmployeeForm> efList = readEmployeeForms();

            for(EmployeeForm ef : efList) {
                checkOneForm(ef);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private List<EmployeeForm> readEmployeeForms() throws DaoException {
        return new EmployeeFormDaoImpl().getEmployeeForm();
    }

    private void checkOneForm(EmployeeForm ef) {
        AnswerJobRegister jobAnswer = checkJobRegister(ef);
    }

    private AnswerJobRegister checkJobRegister(EmployeeForm ef) {
        return jobVal.checkJobRegister(ef);
    }


}

package com.jobhunter.employeeform.domain.register;

import com.jobhunter.employeeform.domain.Employee;

public class AnswerJobRegisterItem {

    public enum JobStatus {
        CONFIRMED, NOT_CONFIRMED, ERROR;
    }

    public static class JobError {
        private String code;
        private String text;

        public JobError(String code, String text) {
            this.code = code;
            this.text = text;
        }

        public String getCode() {
            return code;
        }

        public String getText() {
            return text;
        }
    }

    private JobStatus status;
    private Employee employee;
    private JobError error;

    public AnswerJobRegisterItem(JobStatus status, Employee employee) {
        this.status = status;
        this.employee = employee;
    }

    public AnswerJobRegisterItem(JobStatus status, Employee employee, JobError error) {
        this.status = status;
        this.employee = employee;
        this.error = error;
    }

    public JobStatus getStatus() {
        return status;
    }

    public Employee getEmployee() {
        return employee;
    }

    public JobError getError() {
        return error;
    }
}

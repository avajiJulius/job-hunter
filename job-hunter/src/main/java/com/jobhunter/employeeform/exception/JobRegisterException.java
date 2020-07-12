package com.jobhunter.employeeform.exception;

public class JobRegisterException extends Exception {

    private String code;

    public JobRegisterException(String message, String code) {
        super(message);
        this.code = code;
    }

    public JobRegisterException(String message, Throwable cause, String code) {
        super(message, cause);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}

package com.jobhunter.employeeform.exception;

public class JobRegisterException extends Exception {
    public JobRegisterException() {
        super();
    }

    public JobRegisterException(String message) {
        super(message);
    }

    public JobRegisterException(String message, Throwable cause) {
        super(message, cause);
    }

    public JobRegisterException(Throwable cause) {
        super(cause);
    }
}

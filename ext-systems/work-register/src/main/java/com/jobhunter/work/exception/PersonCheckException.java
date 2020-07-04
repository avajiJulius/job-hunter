package com.jobhunter.work.exception;

public class PersonCheckException extends Exception{
    public PersonCheckException() {
        super();
    }

    public PersonCheckException(String message) {
        super(message);
    }

    public PersonCheckException(String message, Throwable cause) {
        super(message, cause);
    }

    public PersonCheckException(Throwable cause) {
        super(cause);
    }
}

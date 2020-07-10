package com.jobhunter.employeeform.domain;

public enum FormStatus {
    CHECKED, UNCHECKED;

    public static FormStatus fromValue(int value) {
        for(FormStatus fs : FormStatus.values()) {
            if(fs.ordinal() == value)
                return fs;
        }
        throw new RuntimeException("Unknown value: " + value);
    }
}

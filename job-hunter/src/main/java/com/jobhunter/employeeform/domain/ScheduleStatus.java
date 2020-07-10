package com.jobhunter.employeeform.domain;

public enum ScheduleStatus {
    UNSELECTED, FULLDAY, SHIFTWORK, FLEXIBLE, REMOTE, SHIFTMETHOD;

    public static ScheduleStatus fromValue(int value) {
        for(ScheduleStatus ss : ScheduleStatus.values()) {
            if(ss.ordinal() == value)
                return ss;
        }
        throw new RuntimeException("Unknown value: " + value);
    }
}

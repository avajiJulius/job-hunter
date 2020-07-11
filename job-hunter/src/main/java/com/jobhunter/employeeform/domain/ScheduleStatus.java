package com.jobhunter.employeeform.domain;

import java.util.ArrayList;
import java.util.List;

public enum ScheduleStatus {
    UNSELECTED, FULLDAY, SHIFTWORK, FLEXIBLE, REMOTE, SHIFTMETHOD;

    public static ScheduleStatus fromValue(int value) {
        for(ScheduleStatus ss : ScheduleStatus.values()) {
            if(ss.ordinal() == value)
                return ss;
        }
        throw new RuntimeException("Unknown value: " + value);
    }

//    public static List<ScheduleStatus> fromValues(int[] values) {
//        List<ScheduleStatus> result = new ArrayList<>();
//        for(ScheduleStatus ss : ScheduleStatus.values()) {
//            for(int value : values) {
//                if (ss.ordinal() == value)
//                    result.add(ss);
//            }
//        }
//        return result;
//    }
}

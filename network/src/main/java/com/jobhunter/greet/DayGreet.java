package com.jobhunter.greet;

import com.jobhunter.net.Greatable;

public class DayGreet extends Greatable {
    @Override
    public String buildResponse(String userName) {
        return "Good day " + userName;
    }
}

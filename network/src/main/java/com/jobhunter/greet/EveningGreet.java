package com.jobhunter.greet;

import com.jobhunter.net.Greatable;

public class EveningGreet extends Greatable {
    @Override
    public String buildResponse(String userName) {
        return "Good evening " + userName;
    }
}

package com.jobhunter.greet;

import com.jobhunter.net.Greatable;

public class MorningGreet extends Greatable {
    @Override
    public String buildResponse(String userName) {
        return "Good morning " + userName;
    }
}

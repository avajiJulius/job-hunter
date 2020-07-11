package com.jobhunter.employeeform.domain.register;

public class JobRegisterResponse {

    private boolean worked;
    private boolean partial;

    public boolean isWorked() {
        return worked;
    }

    public void setWorked(boolean worked) {
        this.worked = worked;
    }

    public boolean isPartial() {
        return partial;
    }

    public void setPartial(boolean partial) {
        this.partial = partial;
    }


}

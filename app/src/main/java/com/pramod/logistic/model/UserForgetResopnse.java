package com.pramod.logistic.model;

public class UserForgetResopnse {
    private boolean error;
    private String massage;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }
}

package com.pramod.logistic.viewmodel;

import android.util.Patterns;

public class LoginUsers {
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEmailValid() {
      // return Patterns.EMAIL_ADDRESS.matcher(getStrEmailAddress()).matches();
        return false;
    }



    public boolean isPasswordLengthGreaterThan5() {
        //
        //return getStrPassword().length() > 5;
        return false;
    }
}

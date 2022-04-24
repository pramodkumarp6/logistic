package com.pramod.logistic.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.pramod.logistic.activity.RegisterActivity;
import com.pramod.logistic.activity.UserForgetActivity;
import com.pramod.logistic.dash.UserDetailsActivity;
import com.pramod.logistic.repository.LoginRepository;

public class LoginViewModel extends ViewModel {
    public LoginUsers user;
    private Context context;

    private LoginRepository loginRepository;
    public MutableLiveData<String> email = new MutableLiveData<>();
    public MutableLiveData<String> password = new MutableLiveData<>();

    private MutableLiveData<String> valid = new MutableLiveData<>();

    public MutableLiveData<String> getValid() {
        return valid;
    }

    public LoginViewModel(Context context, LoginUsers user, LoginRepository loginRepository) {
        this.user = user;
        this.context = context;
        this.loginRepository = loginRepository;

    }


    public LiveData getData() {
        LoginRepository mainRepository = new LoginRepository();
        return mainRepository.loginUser(email.getValue(),password.getValue());
    }


    public void onLogin() {
        login();

    }


    public void login() {
        user.setEmail(email.getValue());
        user.setPassword(password.getValue());

        if (TextUtils.isEmpty(email.getValue())) {
            valid.setValue("Email Is required");
            return;
        }
        if (TextUtils.isEmpty(password.getValue())) {
            valid.setValue("password  Is required");
            return;
        }


        loginRepository = new LoginRepository();
        loginRepository.loginUser(user.getEmail(), user.getPassword());

        //Log.e(loginRepository.data.getValue().toString(),"LoginRepositoryLoginViewModel");

         Intent intent = new Intent(context, UserDetailsActivity.class);
         context.startActivity(intent);

    }


    public void onRegister() {
        Intent intent = new Intent(context, RegisterActivity.class);
        context.startActivity(intent);

    }

    public void onUserForget() {
        Intent intent = new Intent(context, UserForgetActivity.class);
        context.startActivity(intent);

    }
}

package com.pramod.logistic.viewmodel;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.pramod.logistic.repository.LoginRepository;

public class LoginViewModelFactory implements ViewModelProvider.Factory {
    private LoginUsers user;
    private Context context;
    private LoginRepository loginRepository;


    public LoginViewModelFactory(Context context, LoginUsers users) {
        this.context = context;
        this.user = users;



        //this.loginRepository = loginRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> aClass) {
        LoginViewModel loginViewModel = new LoginViewModel(context,user,loginRepository);

        return (T) (loginViewModel);
    }
}

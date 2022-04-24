package com.pramod.logistic.viewmodel;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.pramod.logistic.activity.RegisterActivity;

public class RegisterViewModelFactory implements ViewModelProvider.Factory {
    private RegisterUser registerUser;
    private Context context;

    public RegisterViewModelFactory(RegisterActivity registerActivity, RegisterUser registerUser) {
        this.context = registerActivity;
        this.registerUser = registerUser;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> aClass) {
        return (T) new  RegisterViewModel(context,registerUser);
    }
}

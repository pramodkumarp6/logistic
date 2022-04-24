package com.pramod.logistic.viewmodel;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.pramod.logistic.activity.UserForgetActivity;

public class UserForgetModelfactory implements ViewModelProvider.Factory {
    private UserForgetUser userForgetuser;
    private Context context;


    public UserForgetModelfactory(UserForgetActivity userForgetActivity, UserForgetUser userForgetUser) {
        this.context = userForgetActivity;
        this.userForgetuser = userForgetuser;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> aClass) {
        return (T) new UserForgetModel(context,userForgetuser);
    }
}

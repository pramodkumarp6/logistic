package com.pramod.logistic.viewmodel;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class UserForgetModel extends ViewModel {
    private UserForgetUser userForgetUser;
    private Context context;
    public MutableLiveData<String>email = new MutableLiveData<>();

    public UserForgetModel(Context context, UserForgetUser userForgetuser) {
        this.userForgetUser = userForgetuser;
        this.context = context;

    }


    public void onForgetUser(){

    }
}

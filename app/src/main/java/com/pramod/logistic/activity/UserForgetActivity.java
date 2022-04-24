package com.pramod.logistic.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.os.Bundle;

import com.pramod.logistic.R;
import com.pramod.logistic.databinding.ActivityUserForgetBinding;
import com.pramod.logistic.viewmodel.UserForgetModel;
import com.pramod.logistic.viewmodel.UserForgetModelfactory;
import com.pramod.logistic.viewmodel.UserForgetUser;

public class UserForgetActivity extends AppCompatActivity {
      private ActivityUserForgetBinding activityUserForgetBinding;
      private UserForgetModel userForgetModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityUserForgetBinding = DataBindingUtil.setContentView(this,R.layout.activity_user_forget);
        userForgetModel = new ViewModelProvider(this,new UserForgetModelfactory(this,new UserForgetUser())).get(UserForgetModel.class);
        activityUserForgetBinding.setUserForgetModel(userForgetModel);

    }
}
package com.pramod.logistic.activity;

import androidx.activity.result.ActivityResultCaller;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.pramod.logistic.R;
import com.pramod.logistic.databinding.ActivityRegisterBinding;
import com.pramod.logistic.viewmodel.RegisterUser;
import com.pramod.logistic.viewmodel.RegisterViewModel;
import com.pramod.logistic.viewmodel.RegisterViewModelFactory;

public class RegisterActivity extends AppCompatActivity {
 private ActivityRegisterBinding resgisterBinding;
 private RegisterViewModel registerViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        resgisterBinding = DataBindingUtil.setContentView(this, R.layout.activity_register);
        registerViewModel = new ViewModelProvider(this,new RegisterViewModelFactory(this,new RegisterUser())).get(RegisterViewModel.class);
        resgisterBinding.setRegisterViewModel(registerViewModel);

        registerViewModel.getData().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Log.e(s,"pramodkumar");
                Toast.makeText(RegisterActivity.this, s, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
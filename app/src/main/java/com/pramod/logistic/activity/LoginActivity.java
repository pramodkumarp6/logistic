package com.pramod.logistic.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.pramod.logistic.R;
import com.pramod.logistic.databinding.ActivityLoginBinding;
import com.pramod.logistic.viewmodel.LoginViewModel;
import com.pramod.logistic.viewmodel.LoginViewModelFactory;
import com.pramod.logistic.viewmodel.LoginUsers;

public class LoginActivity extends AppCompatActivity  {

    private ActivityLoginBinding loginBinding;
    private LoginViewModel loginViewModel;
    private Object String;
    private ProgressDialog progressDialog;

    protected void onCreate(Bundle savedIntanceState) {
        super.onCreate(savedIntanceState);
        loginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        loginViewModel = new ViewModelProvider(this, new LoginViewModelFactory(this, new LoginUsers())).get(LoginViewModel.class);
        loginBinding.setLoginViewModel(loginViewModel);
        loginViewModel.getValid().observe(this, new Observer<java.lang.String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(LoginActivity.this, s, Toast.LENGTH_SHORT).show();

            }
        });






        getData();
    }
    private void getData() {
        loginViewModel.getData().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Log.e("Data", s);
                Toast.makeText(LoginActivity.this, s, Toast.LENGTH_SHORT).show();

            }


        });



    }

}
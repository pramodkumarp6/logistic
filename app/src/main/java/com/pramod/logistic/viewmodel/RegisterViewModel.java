package com.pramod.logistic.viewmodel;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.pramod.logistic.repository.RegisterRepository;

public class RegisterViewModel extends ViewModel {
    private Context context;
    private RegisterUser registerUser;
    private RegisterRepository registerRepository;
    public ObservableField<String>email = new ObservableField<>();
    public ObservableField<String>password = new ObservableField<>();
    public ObservableField<String>name = new ObservableField<>();
    public ObservableField<String>school = new ObservableField<>();



    public RegisterViewModel(Context context, RegisterUser registerUser) {
        this.registerUser = registerUser;
        this.context = context;
    }

    public LiveData getData() {
        registerRepository  = new RegisterRepository();
        return registerRepository.getValue();


    }




    public void onRegister(){
        registerModel();
    }

    private void registerModel() {
        if(TextUtils.isEmpty(email.get())){
            Toast.makeText(context, "Email is Required", Toast.LENGTH_SHORT).show();
            return;

        }

        if(TextUtils.isEmpty(password.get())){
            Toast.makeText(context, "Password Is Required", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(name.get())){
            Toast.makeText(context, "Name is Required", Toast.LENGTH_SHORT).show();
            return;

        }

        if(TextUtils.isEmpty(school.get())){
            Toast.makeText(context, "School Is Required", Toast.LENGTH_SHORT).show();
            return;
        }
        registerRepository = new RegisterRepository();
        registerRepository.getRegister(email.get(),password.get(),name.get(),school.get());
    }
}

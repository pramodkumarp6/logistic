package com.pramod.logistic.viewmodel;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.pramod.logistic.model.RegisterResponse;
import com.pramod.logistic.repository.RegisterRepository;

public class RegisterViewModel extends ViewModel {
    private Context context;
    private RegisterUser registerUser;
    private RegisterRepository registerRepository;
    public ObservableField<String>email = new ObservableField<>();
    public ObservableField<String>password = new ObservableField<>();
    public ObservableField<String>name = new ObservableField<>();
    public ObservableField<String>school = new ObservableField<>();
    private MutableLiveData<String> vaidate = new MutableLiveData<>();


    public LiveData<String> getVaidate() {
        return vaidate;
    }

    public RegisterViewModel(Context context, RegisterUser registerUser) {
        this.registerUser = registerUser;
        this.context = context;
    }





    public void onRegister(){
        register();
        Validate();

    }


    /*public LiveData<RegisterResponse> getData() {
        registerRepository  = new RegisterRepository();
        return registerRepository.getData();
    }*/




public void Validate(){
    if(TextUtils.isEmpty(email.get())){
        vaidate.setValue("Email is Required");
        return;

    }

    if(TextUtils.isEmpty(password.get())){
        vaidate.setValue("Password is Required");

        return;
    }
    if(TextUtils.isEmpty(name.get())){
        vaidate.setValue("Name is Required");

        return;

    }

    if(TextUtils.isEmpty(school.get())){
        vaidate.setValue("School is Required");

        return;
    }
}


    public LiveData<RegisterResponse> register() {

         registerRepository = new RegisterRepository();
        return registerRepository.getRegister(email.get(),  password.get(),  name.get(), school.get());
    }
}

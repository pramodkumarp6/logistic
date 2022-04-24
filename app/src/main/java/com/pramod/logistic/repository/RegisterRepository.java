package com.pramod.logistic.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.pramod.logistic.api.RetrofitClient;
import com.pramod.logistic.model.RegisterResponse;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RegisterRepository {
    private MutableLiveData<String> data = new MutableLiveData<>();
    public MutableLiveData getValue() {
        data.setValue("welcome");
        return data;
    }




    public MutableLiveData<String>getRegister(String email,String password,String name,String school){
        Observable<RegisterResponse> observable = RetrofitClient.getInstance().getApi().userCreate(email,password,name,school)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(new Observer<RegisterResponse>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(RegisterResponse registerResponse) {
                registerResponse.getMessage();
                Log.e("Message",registerResponse.getMessage());
                data.setValue(registerResponse.getMessage());


            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });




        return data;
    }



    }




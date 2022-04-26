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


    public  MutableLiveData<RegisterResponse> getRegister(String email, String password, String name, String school){
        final MutableLiveData<RegisterResponse> data = new MutableLiveData<>();

        Observable<RegisterResponse> observable = RetrofitClient.getInstance().getApi().createUser(email,password,name,school)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(new Observer<RegisterResponse>() {
            @Override
            public void onSubscribe(Disposable d) {

                }

                @Override
                public void onNext(RegisterResponse registerResponse) {

                        Log.e("Message", registerResponse.getMessage());
                        data.setValue(registerResponse);




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








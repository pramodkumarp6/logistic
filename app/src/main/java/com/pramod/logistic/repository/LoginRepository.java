package com.pramod.logistic.repository;

import android.util.Log;


import androidx.lifecycle.MutableLiveData;

import com.pramod.logistic.api.RetrofitClient;
import com.pramod.logistic.model.LoginResponse;
import com.pramod.logistic.model.User;


import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LoginRepository {




    private  MutableLiveData<String> data = new MutableLiveData();
    private  MutableLiveData tata = new MutableLiveData();






   public MutableLiveData<String> loginUser(String email,String password) {


       Observable<LoginResponse> observable = RetrofitClient.getInstance().getApi().userLogin(email, password)
               .subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread());
       observable.subscribe(new Observer<LoginResponse>() {
           @Override
           public void onSubscribe(Disposable d) {

           }

           @Override
           public void onNext(LoginResponse response) {
               // loginPresenter.onHide();
               LoginResponse loginResponse = response;
               if (!loginResponse.isError()) {

                   User user = loginResponse.getUser();
                   int id = user.getId();
                   String email = user.getEmail();
                   String name = user.getName();
                   String school = user.getName();


                   //   data.setValue(email);
                   Log.e(String.valueOf(id), "userEmailRepository");
                   Log.e(email, "userEmailRepository");

                   User users = new User(id,email,name,school);

                   data.setValue("");

               } else {
                   data.setValue(loginResponse.getMessage());
               }

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



  /*  public MutableLiveData getMyname() {
            //data.setValue("Hello@gmail.com");
        return data;
    }*/




}

package com.pramod.logistic.api;

import com.pramod.logistic.dash.ui.slideshow.UserResponse;
import com.pramod.logistic.model.LoginResponse;
import com.pramod.logistic.model.RegisterResponse;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {

    @FormUrlEncoded
    @POST("/simple/public/userlogin")
    Observable<LoginResponse> userLogin(@Field("email") String email,
                                        @Field("password") String password);


    @FormUrlEncoded
    @POST("/simple/public/createuser")
    Observable<RegisterResponse> userCreate(@Field("email") String email,
                                            @Field("password") String password,
                                            @Field("name") String name,
                                            @Field("school") String school


    );




    @GET("/simple/public/allusers")
    Observable<UserResponse> userData();
}

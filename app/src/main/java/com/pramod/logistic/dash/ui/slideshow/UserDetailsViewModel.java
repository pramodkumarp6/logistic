package com.pramod.logistic.dash.ui.slideshow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class UserDetailsViewModel extends ViewModel {

    private UserDetailsRepository userDetailsRepository;

    public MutableLiveData<UserResponse> getUserDetails() {
        userDetailsRepository = new UserDetailsRepository();
        return userDetailsRepository.dataView();
    }


}
package com.pramod.logistic.viewmodel;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class HomeViewModelFactory implements ViewModelProvider.Factory {
    private Context context;
    private PostImage postImage;

    public HomeViewModelFactory(Context context, PostImage postImage) {
        this.context = context;
        this.postImage = postImage;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> aClass) {
        return (T) new HomeViewModel(context,postImage);
    }
}
